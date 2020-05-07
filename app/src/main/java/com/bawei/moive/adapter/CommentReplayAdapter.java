package com.bawei.moive.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.moive.R;
import com.bawei.moive.bean.CommentReplayBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class CommentReplayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private Context mContext;
    private List<CommentReplayBean.ResultBean> mList = new ArrayList();

    public CommentReplayAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<CommentReplayBean.ResultBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_replay, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).ivTouxiang.setImageURI(Uri.parse(mList.get(position).getReplyHeadPic()));
        ((ViewHolder)holder).tvName.setText(mList.get(position).getReplyUserName());
        Date date = new Date(mList.get(position).getReplyTime());
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        ((ViewHolder)holder).tvTime.setText(format);
        ((ViewHolder)holder).tvComment.setText(mList.get(position).getReplyContent());
    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_touxiang)
        SimpleDraweeView ivTouxiang;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.rl)
        RelativeLayout rl;
        @BindView(R.id.tv_comment)
        TextView tvComment;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
