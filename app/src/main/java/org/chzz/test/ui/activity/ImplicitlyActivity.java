package org.chzz.test.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.chzz.test.R;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/6/15
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/6/15--10:17
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/
public class ImplicitlyActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicitly);
    }

    @Override
    protected void setListener() {

    }
}
