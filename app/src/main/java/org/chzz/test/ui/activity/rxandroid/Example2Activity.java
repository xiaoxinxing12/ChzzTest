package org.chzz.test.ui.activity.rxandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.chzz.test.R;
import org.chzz.test.adapter.RecyclerViewAdapter;
import org.chzz.test.ui.activity.BaseActivity;

import java.util.List;
import java.util.concurrent.Callable;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
public class Example2Activity extends BaseActivity {
    private RecyclerView mColorListView;
    RecyclerViewAdapter mAdapter;
    private Subscription mTvShowSubscription;
    private RestClient mRestClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxandroid_1);
        mColorListView = (RecyclerView) findViewById(R.id.color_list);
        mColorListView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecyclerViewAdapter(this);
        mColorListView.setAdapter(mAdapter);
        mRestClient=new RestClient(this);
        createObservable();

    }

    private void createObservable() {
        Observable<List<String>> listObservable = Observable.fromCallable(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                return mRestClient.getFavoriteTvShows();
            }
        });
        mTvShowSubscription = listObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<String> strings) {
                        displayTvShows(strings);
                    }
                });
    }

    private void displayTvShows(List<String> tvShows) {
        mAdapter.setStrings(tvShows);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mTvShowSubscription != null && !mTvShowSubscription.isUnsubscribed()) {
            mTvShowSubscription.unsubscribe();
        }
    }
    @Override
    protected void setListener() {

    }
}
