package com.bawei.moive.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.moive.R;
import com.bawei.moive.activity.DetailsActivity;
import com.bawei.moive.bean.UpcomingBean;
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
public class MovieUpcomingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private Context mContext;
    private List<UpcomingBean.ResultBean> mList = new ArrayList();

    public MovieUpcomingAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<UpcomingBean.ResultBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_upcomingmovie, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).tv1.setText(mList.get(position).getName());
        Date date = new Date(mList.get(position).getReleaseTime());
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
        String[] split = format.split("-");
        ((ViewHolder) holder).tv2.setText(split[1] + "月" + split[2] + "日" + "上映");
        ((ViewHolder) holder).tv3.setText(String.valueOf(mList.get(position).getWantSeeNum()) + "人想看");
//        Glide.with(mContext).load(mList.get(position).getImageUrl()).into(((ViewHolder) holder).iv);
        ((ViewHolder)holder).iv.setImageURI(Uri.parse(mList.get(position).getImageUrl()));
        ((ViewHolder)holder).rl.setOnClickListener(new View.OnClickListener() {
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
        //        @BindView(R.id.iv)
//        ImageView iv;
        @BindView(R.id.iv)
        SimpleDraweeView iv;
        @BindView(R.id.tv1)
        TextView tv1;
        @BindView(R.id.tv2)
        TextView tv2;
        @BindView(R.id.tv3)
        TextView tv3;
        @BindView(R.id.tv4)
        TextView tv4;
        @BindView(R.id.bt_buy)
        Button btBuy;
        @BindView(R.id.rl)
        RelativeLayout rl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
