package org.chzz.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.chzz.test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/7/4
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/7/4--10:18
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mStrings = new ArrayList<>();

    public RecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public void setStrings(List<String> strings) {
        mStrings = strings;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.string_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mColorDisplay.setText(mStrings.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mStrings.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStrings.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mColorDisplay;

        public ViewHolder(View itemView) {
            super(itemView);
            mColorDisplay = (TextView) itemView.findViewById(R.id.color_display);
        }
    }
}
