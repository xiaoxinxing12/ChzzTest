package org.chzz.test.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.chzz.test.R;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/6/15
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/6/15--10:03
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/
public class ActivityActivity extends BaseActivity {

    private Button mImplicitly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        mImplicitly = (Button) findViewById(R.id.but_Implicitly);

    }

    @Override
    protected void setListener() {
        mImplicitly.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_Implicitly:
               // Uri data = Uri.parse("tel:15013576011" );
                Intent _implicitly = new Intent();
                _implicitly.setAction("org.chzz.implicitly");
              //  _implicitly.setData(data);
                startActivity(_implicitly);
                break;
        }
    }
}
