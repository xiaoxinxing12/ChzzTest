package org.chzz.test.ui.activity.rxandroid;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/7/4
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/7/4--11:03
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/
public class RestClient {

    private Context mContext;

    public RestClient(Context context) {
        mContext = context;
    }

    public List<String> getFavoriteTvShows() {
        try {
            // "Simulate" the delay of network.
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return createTvShowList();
    }

    public List<String> getFavoriteTvShowsWithException() {
        try {
            // "Simulate" the delay of network.
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Failed to load");
    }

    private List<String> createTvShowList() {
        List<String> tvShows = new ArrayList<>();
        tvShows.add("The Joy of Painting");
        tvShows.add("The Simpsons");
        tvShows.add("Futurama");
        tvShows.add("Rick & Morty");
        tvShows.add("The X-Files");
        tvShows.add("Star Trek: The Next Generation");
        tvShows.add("Archer");
        tvShows.add("30 Rock");
        tvShows.add("Bob's Burgers");
        tvShows.add("Breaking Bad");
        tvShows.add("Parks and Recreation");
        tvShows.add("House of Cards");
        tvShows.add("Game of Thrones");
        tvShows.add("Law And Order");
        return tvShows;
    }


}
