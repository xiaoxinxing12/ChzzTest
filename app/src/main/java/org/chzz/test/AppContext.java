package org.chzz.test;

import android.app.Activity;
import android.app.Application;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/6/16
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/6/16--10:59
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/

public class AppContext extends Application {
    public static Activity activity;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
