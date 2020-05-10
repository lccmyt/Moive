package com.bawei.moive.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.moive.R;
import com.bawei.moive.bean.NearByBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: Demo_050301
 * @Package: com.bawei.demo_050301.adapter
 * @ClassName: MovieAdapter
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/5/3 19:16
 */
public class NearByCinemasAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<NearByBean.ResultBean> mList = new ArrayList<>();

    public NearByCinemasAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<NearByBean.ResultBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_nearbycinemas, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).iv.setImageURI(Uri.parse(mList.get(position).getLogo()));
        ((ViewHolder) holder).tvName.setText(mList.get(position).getName());
        ((ViewHolder) holder).tvDao.setText(mList.get(position).getAddress());
        ((ViewHolder) holder).juli.setText(String.valueOf(mList.get(position).getDistance()) + "米");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv)
        SimpleDraweeView iv;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_dao)
        TextView tvDao;
        @BindView(R.id.juli)
        TextView juli;
        @BindView(R.id.rl)
        RelativeLayout rl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
