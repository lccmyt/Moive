package com.bawei.moive.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.moive.R;
import com.bawei.moive.activity.CommentDetailsActivity;
import com.bawei.moive.bean.FilmReviewBean;
import com.bawei.moive.view.RatingBar;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class FilmReviewlAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private Context mContext;
    private List<FilmReviewBean.ResultBean> mList = new ArrayList<>();

    public FilmReviewlAdapter(Context context) {
        mContext = context;
    }

    Dialog dialog;

    public void setData(List<FilmReviewBean.ResultBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_filmreview, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).yingPingName.setText(mList.get(position).getCommentUserName());
        ((ViewHolder)holder).yingPingImg.setImageURI(Uri.parse(mList.get(position).getCommentHeadPic()));
        ((ViewHolder)holder).yingPingFen.setText(String.valueOf(mList.get(position).getScore()));
        ((ViewHolder)holder).yingPingJieshao.setText(mList.get(position).getCommentContent());
        ((ViewHolder)holder).yingPingCount.setText("等"+String.valueOf(mList.get(position).getReplyNum())+"人进行了回复");
        Date date = new Date(mList.get(position).getCommentTime());
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        ((ViewHolder)holder).yingPingZuoRen.setText(String.valueOf(mList.get(position).getGreatNum()));
        ((ViewHolder)holder).yingPingShijian.setText(format);
        ((ViewHolder)holder).rbb.setStar((float) (mList.get(position).getScore()/2));
        ((ViewHolder)holder).rbb.setClickable(false);
        ((ViewHolder)holder).yingPingCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CommentDetailsActivity.class);
                intent.putExtra("comment", mList.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ying_ping_img)
        SimpleDraweeView yingPingImg;
        @BindView(R.id.ying_ping_name)
        TextView yingPingName;
        @BindView(R.id.rbb)
        RatingBar rbb;
        @BindView(R.id.ying_ping_fen)
        TextView yingPingFen;
        @BindView(R.id.ying_ping_shijian)
        TextView yingPingShijian;
        @BindView(R.id.ying_ping_jieshao)
        TextView yingPingJieshao;
        @BindView(R.id.dianzan)
        ImageView dianzan;
        @BindView(R.id.ying_ping_zuo_ren)
        TextView yingPingZuoRen;
        @BindView(R.id.ying_ping_count)
        TextView yingPingCount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
