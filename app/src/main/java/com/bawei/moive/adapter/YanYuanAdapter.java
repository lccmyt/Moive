package com.bawei.moive.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.moive.R;
import com.bawei.moive.bean.DetailsMovieBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: Week01
 * @Package: com.bawei.week01.adapter
 * @ClassName: MoiveLoadingAdapter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/18 21:20
 */
public class YanYuanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private Context mContext;
    private List<DetailsMovieBean.ResultBean.MovieActorBean> mList = new ArrayList();

    public YanYuanAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<DetailsMovieBean.ResultBean.MovieActorBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_yanyuan, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).tv1.setText(mList.get(position).getName());
        ((ViewHolder)holder).tv2.setText(mList.get(position).getRole());
        ((ViewHolder)holder).iv.setImageURI(Uri.parse(mList.get(position).getPhoto()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv)
        SimpleDraweeView iv;
        @BindView(R.id.tv1)
        TextView tv1;
        @BindView(R.id.tv2)
        TextView tv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
