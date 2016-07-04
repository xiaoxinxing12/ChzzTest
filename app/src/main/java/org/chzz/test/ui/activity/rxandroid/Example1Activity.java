package org.chzz.test.ui.activity.rxandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.chzz.test.R;
import org.chzz.test.adapter.RecyclerViewAdapter;
import org.chzz.test.ui.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;

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
public class Example1Activity extends BaseActivity {
    private RecyclerView mColorListView;
    RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxandroid_1);
        mColorListView = (RecyclerView) findViewById(R.id.color_list);
        mColorListView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerViewAdapter(this);
        mColorListView.setAdapter(mAdapter);
        createObservable();

    }

    private void createObservable() {
        Observable<List<String>> list = Observable.just(getColorList());
        list.subscribe(new Observer<List<String>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<String> strings) {
                     mAdapter.setStrings(strings);
            }
        });

    }

    private static List<String> getColorList() {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("blue");
        colors.add("green");
        colors.add("red");
        colors.add("chartreuse");
        colors.add("Van Dyke Brown");
        return colors;
    }

    @Override
    protected void setListener() {

    }
}
