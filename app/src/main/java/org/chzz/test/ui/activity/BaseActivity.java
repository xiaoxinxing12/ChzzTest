package org.chzz.test.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.chzz.test.R;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/6/15
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/6/15--10:14
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener  {
    protected abstract void setListener();

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_activity:
                Intent _activity = new Intent(this, ActivityActivity.class);
                startActivity(_activity);
                break;
        }
    }
}
