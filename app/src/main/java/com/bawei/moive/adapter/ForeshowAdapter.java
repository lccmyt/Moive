package com.bawei.moive.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.bawei.moive.R;
import com.bawei.moive.bean.DetailsMovieBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.adapter
 * @ClassName: ForeshowAdapter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/5 20:04
 */
public class ForeshowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<DetailsMovieBean.ResultBean.ShortFilmListBean> mList = new ArrayList<>();

    public ForeshowAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<DetailsMovieBean.ResultBean.ShortFilmListBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_foreshow, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Glide.with(mContext).load(mList.get(position).getImageUrl()).into(((ViewHolder) holder).foreshowIv);
        ((ViewHolder)holder).foreshowVv.setVideoPath(mList.get(position).getVideoUrl());
        ((ViewHolder)holder).foreshowVvStart.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                ((ViewHolder)holder).foreshowIv.setVisibility(8);
                ((ViewHolder)holder).foreshowVvStart.setVisibility(8);
                ((ViewHolder)holder).foreshowVv.setVisibility(0);
                ((ViewHolder)holder).foreshowVv.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.foreshow_vv)
        VideoView foreshowVv;
        @BindView(R.id.foreshow_vv_start)
        ImageView foreshowVvStart;
        @BindView(R.id.foreshow_iv)
        ImageView foreshowIv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
