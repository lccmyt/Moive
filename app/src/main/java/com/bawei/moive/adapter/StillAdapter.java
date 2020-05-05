package com.bawei.moive.adapter;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bawei.moive.R;
import com.bawei.moive.bean.DetailsMovieBean;
import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;

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
public class StillAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<DetailsMovieBean.ResultBean> mList = new ArrayList<>();

    public StillAdapter(Context context) {
        mContext = context;
    }
    Dialog dialog;
    public void setData(List<DetailsMovieBean.ResultBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_still, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Glide.with(mContext).load(mList.get(0).getPosterList().get(position)).into(((ViewHolder) holder).stillIv);
        ((ViewHolder)holder).stillIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog == null) {
                    dialog = new Dialog(mContext);
                    View view = View.inflate(mContext, R.layout.dialog_still, null);
                    ImageView iv = view.findViewById(R.id.still_ivv);
                    Glide.with(mContext).load(mList.get(position).getPosterList().get(position)).into(iv);
                    dialog.addContentView(view,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    dialog.show();
                }else {
                    Dialog dialog1 = new Dialog(mContext);
                    View view = View.inflate(mContext, R.layout.dialog_still, null);
                    ImageView iv = view.findViewById(R.id.still_ivv);
                    Glide.with(mContext).load(mList.get(position).getPosterList().get(position)).into(iv);
                    dialog1.addContentView(view,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    dialog1.show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.still_iv)
        ImageView stillIv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
