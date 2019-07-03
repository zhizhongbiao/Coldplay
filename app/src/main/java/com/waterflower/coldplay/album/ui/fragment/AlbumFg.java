package com.waterflower.coldplay.album.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.waterflower.coldplay.R;
import com.waterflower.coldplay.album.bean.NewListBean;
import com.waterflower.coldplay.album.ui.activity.ActivityDetailActivity;
import com.waterflower.coldplay.album.ui.adapter.AlbumAdapter;
import com.waterflower.coldplay.waterflower.basic.model.BaseBean;
import com.waterflower.coldplay.waterflower.basic.network.ApiConfig;
import com.waterflower.coldplay.waterflower.basic.network.ResponseInfo;
import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.basic.view.MvpFragment;
import com.waterflower.coldplay.waterflower.basic.widget.refresh.NestedRefreshLayout;
import com.waterflower.coldplay.waterflower.basic.widget.refresh.RefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;


/**
 * Author : WaterFlower.
 * Created on 2017/8/23.
 * Desc :
 */

public class AlbumFg extends MvpFragment<MvpPresenter>
        implements NestedRefreshLayout.OnRefreshListener
        , BaseQuickAdapter.RequestLoadMoreListener
        , BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.refreshLayout)
    RefreshLayout refreshLayout;


    private int page = 1;
    private AlbumAdapter adapter;
    private int totalPage;


    public static AlbumFg newInstance() {
        AlbumFg newInstance = new AlbumFg();
        return newInstance;
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(Bundle savedInstanceState, Bundle args) {
        initRv();
        refreshLayout.setOnRefreshListener(this);
    }


    @Override
    protected void loadData(Bundle savedInstanceState) {
//        HomeListUtil.getEstateList(presenter, currentType, page, housePriceKey, regionId, houseTypeKey, keyword);
//        refreshLayout.froceRefreshToState(true);
    }


    @Override
    public void showContentView(String url, BaseBean baseBean) {
        if (url.contains(ApiConfig.API_REGION_LIST_FILTER)) {


        } else if (url.contains(ApiConfig.API_SUBJECT_FILTER_LIST)) {

        } else {

        }
        closeRefresh(refreshLayout);
    }


    private void initRv() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AlbumAdapter(getActivity());
        adapter.bindToRecyclerView(rv);
        adapter.setEmptyView(R.layout.view_empty_list);
        adapter.openLoadAnimation();
        adapter.setOnLoadMoreListener(this, rv);
        adapter.setOnItemClickListener(this);

        ArrayList<NewListBean.DataBean> dataBeans = new ArrayList<>();
        dataBeans.add(new NewListBean.DataBean());
        adapter.setNewData(dataBeans);
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        getActivity().startActivity(ActivityDetailActivity.getIntent(getContext()));
    }


    /**
     * 关闭刷新和加载更多
     *
     * @param refreshLayout
     */
    private void closeRefresh(RefreshLayout refreshLayout) {
        if (refreshLayout != null && refreshLayout.isOnRefreshing()) {
            refreshLayout.refreshFinish();
        }
        if (adapter != null && adapter.isLoading()) {
            if (page >= totalPage) {
                adapter.loadMoreEnd();
                return;
            }
            adapter.loadMoreComplete();
        }

    }


    /**
     * 刷新
     */
    @Override
    public void onRefresh() {
        adapter.getData().clear();
        presenter.setNeedDialog(false);
        page = 1;
    }


    /**
     * 加载更多
     */
    @Override
    public void onLoadMoreRequested() {
        presenter.setNeedDialog(false);
        page++;

    }


    /**
     * 出错关闭刷新
     *
     * @param responseInfo
     */
    @Override
    public void onError(ResponseInfo responseInfo) {
        if (page > 1) {
            page--;
        }
        closeRefresh(refreshLayout);
        super.onError(responseInfo);
    }


}
