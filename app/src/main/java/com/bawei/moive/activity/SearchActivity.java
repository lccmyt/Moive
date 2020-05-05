package com.bawei.moive.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bawei.moive.R;
import com.bawei.moive.adapter.MoreLoadingMovieAdapter;
import com.bawei.moive.base.BaseActivity;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.bean.LoadingMovieBean;
import com.bawei.moive.contract.SearchMovieContract;
import com.bawei.moive.presenter.SearchMoviePresenter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity implements SearchMovieContract.IView {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rc1)
    RecyclerView rc1;
    @BindView(R.id.search_nowork_ll)
    LinearLayout searchNoworkLl;
    private MoreLoadingMovieAdapter moreLoadingMovieAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected BasePresenter initPresent() {
        return new SearchMoviePresenter(this);
    }

    @Override
    protected void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rc1.setLayoutManager(linearLayoutManager);
        moreLoadingMovieAdapter = new MoreLoadingMovieAdapter(this);
        rc1.setAdapter(moreLoadingMovieAdapter);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String search = intent.getStringExtra("search");
        et1.setText(search);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back, R.id.iv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.iv_search:
                BasePresenter presenter = getPresenter();
                if (presenter instanceof SearchMoviePresenter) {
                    ((SearchMoviePresenter)presenter).doLogin(et1.getText().toString(),1,30);
                }
                break;
                default:
                    break;
        }
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onSuccess(LoadingMovieBean loadingMovieBean) {
        if (loadingMovieBean != null) {
            if (loadingMovieBean.getResult() == null) {
                rc1.setVisibility(8);
                searchNoworkLl.setVisibility(0);
            }else {
                rc1.setVisibility(0);
                searchNoworkLl.setVisibility(8);
                moreLoadingMovieAdapter.setData(loadingMovieBean.getResult());
            }
        }
    }

    @Override
    public void onFailure(String str) {

    }
}
