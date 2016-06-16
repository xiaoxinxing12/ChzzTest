package org.chzz.test.ui.activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.chzz.test.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/6/16
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/6/16--9:47
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/
public class FileActivity extends BaseActivity {
    private Button mFileA, mFileB;
    private String path = Environment.getExternalStorageDirectory().getAbsolutePath();
    private ProgressBar mPb;
    long startTime, endTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        mFileA = (Button) findViewById(R.id.but_FileA);
        mFileB = (Button) findViewById(R.id.but_FileB);
        mPb = (ProgressBar) findViewById(R.id.pb);
        setListener();
    }

    @Override
    protected void setListener() {
        mFileA.setOnClickListener(this);
        mFileB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mPb.setVisibility(View.VISIBLE);
        startTime = System.currentTimeMillis();

        switch (v.getId()) {
            case R.id.but_FileA:
                copyA(path, path, 1000);
                break;
            case R.id.but_FileB:
                copyB(path, path);
                break;
        }
    }

    /**
     * 使用FileStream
     *
     * @param from
     * @param to
     * @param bufferSize
     */
    public void copyA(String from, String to, int bufferSize) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(new File(from + "/1.txt"));
            out = new FileOutputStream(new File(to + "/2.txt"));
            byte[] buffer = new byte[bufferSize];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            in.close();
            out.close();
            endTime = System.currentTimeMillis();
            result();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 使用FileChannel
     *
     * @param from
     * @param to
     */
    private void copyB(String from, String to) {
        FileChannel in = null;
        FileChannel out = null;
        try {
            in = new FileInputStream(new File(from + "/1.txt")).getChannel();
            out = new FileOutputStream(new File(to + "/3.txt")).getChannel();
            out.transferFrom(in, 0, in.size());
            in.close();
            out.close();
            endTime = System.currentTimeMillis();
            result();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    private void result() {
        Toast.makeText(this, "完成" + (endTime - startTime), Toast.LENGTH_LONG).show();
        mPb.setVisibility(View.GONE);
    }
}
