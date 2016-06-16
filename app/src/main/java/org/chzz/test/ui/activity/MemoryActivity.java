package org.chzz.test.ui.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.chzz.test.R;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/6/16
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/6/16--10:54
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/

public class MemoryActivity extends BaseActivity {
    /**
     * 一、最容易泄露Activity的方式莫过于定义一个类，类的内部通过静态变量的方式持有Activity，然后在运行中，
     * 将Activity实例赋值给这个变量。如果这个静态变量的引用在Activity的生命周期结束前没有置空的话，Activity实例就泄露了。
     * 因为被静态变量持有的对象，它将会被保持在内存中，在App的运行过程中一直存在。如果有一个静态变量持有了Activity的引用
     * ，那么这个Activity就无法被垃圾回收器回收
     */
    private static MemoryActivity activity1;
    private Button mMemoryTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        mMemoryTest = (Button) findViewById(R.id.but_MemoryTest);
        setListener();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_MemoryTest:
                setStaticActivity();
                //startAsyncTask();
                Toast.makeText(this,"开始了",Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    protected void setListener() {
        mMemoryTest.setOnClickListener(this);
    }

    void setStaticActivity() {
        activity1 = this;

    }

    void startAsyncTask() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                while (true) ;
            }
        }.execute();
    }
}
