package org.chzz.test.ui.activity.rxandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import org.chzz.test.R;
import org.chzz.test.ui.activity.BaseActivity;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/7/4
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/7/4--10:10
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/
public class RxAndroidMainActivity extends BaseActivity {

    private Button mExample1,mExample2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxandroid_main);
        mExample1 = (Button) findViewById(R.id.but_1);
        mExample2 = (Button) findViewById(R.id.but_2);
    }

    @Override
    protected void setListener() {
        mExample1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent _intent = null;
        switch (v.getId()) {
            case R.id.but_1:
                _intent = new Intent(this, Example1Activity.class);
                break;
            case R.id.but_2:
                _intent = new Intent(this, Example2Activity.class);
                break;
            case R.id.but_3:
                _intent = new Intent(this, Example3Activity.class);
                break;
        }
        if (null == _intent)
            return;
        startActivity(_intent);
    }
}
