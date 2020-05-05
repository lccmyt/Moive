package com.bawei.moive.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.moive.R;
import com.bawei.moive.activity.DetailsActivity;
import com.bawei.moive.bean.LoadingMovieBean;
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
public class MoreHotMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private Context mContext;
    private List<LoadingMovieBean.ResultBean> mList = new ArrayList();

    public MoreHotMovieAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<LoadingMovieBean.ResultBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_more_movie, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).tvName.setText(mList.get(position).getName());
        ((ViewHolder)holder).tvDirector.setText("导演:  " +   mList.get(position).getDirector());
        ((ViewHolder)holder).tvStarring.setText("主演:  " +   mList.get(position).getStarring());
        ((ViewHolder)holder).tvGrade.setText("评分:  " +   String.valueOf(mList.get(position).getScore()) + "分");
        ((ViewHolder)holder).iv.setImageURI(Uri.parse(mList.get(position).getImageUrl()));
        ((ViewHolder)holder).ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra("movieId", mList.get(position).getMovieId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv)
        SimpleDraweeView iv;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_director)
        TextView tvDirector;
        @BindView(R.id.tv_starring)
        TextView tvStarring;
        @BindView(R.id.tv_grade)
        TextView tvGrade;
        @BindView(R.id.bt_buy)
        Button btBuy;
        @BindView(R.id.ll)
        LinearLayout ll;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
