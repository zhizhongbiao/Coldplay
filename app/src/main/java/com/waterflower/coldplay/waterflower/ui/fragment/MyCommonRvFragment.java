package com.waterflower.coldplay.waterflower.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.waterflower.coldplay.R;
import com.waterflower.coldplay.waterflower.adapter.MyBaseAdapter;
import com.waterflower.coldplay.waterflower.basic.model.BaseBean;
import com.waterflower.coldplay.waterflower.basic.network.ResponseInfo;
import com.waterflower.coldplay.waterflower.basic.presenter.MvpPresenter;
import com.waterflower.coldplay.waterflower.basic.utils.LogUtils;
import com.waterflower.coldplay.waterflower.basic.view.MvpFragment;
import com.waterflower.coldplay.waterflower.basic.widget.refresh.NestedRefreshLayout;
import com.waterflower.coldplay.waterflower.basic.widget.refresh.RefreshLayout;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import butterknife.BindView;


/**
 * Filename :  CommonRvFragment
 * Author   :  zhizhongbiao
 * Date     :  2018/6/29
 * Describe :
 */

public abstract class MyCommonRvFragment<P extends MvpPresenter , A extends MyBaseAdapter, D,L extends LinearLayoutManager>
        extends MvpFragment<P>
        implements BaseQuickAdapter.RequestLoadMoreListener
        , NestedRefreshLayout.OnRefreshListener
        , BaseQuickAdapter.OnItemClickListener{

    public static final int TYPE_ALL = 999;

    protected L layoutManager;
    protected A adapter;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.refreshLayout)
    RefreshLayout refreshLayout;

    private int page = 1;
    private int totalPage;
    private int defaultPageSize=10;


    protected abstract int getDataType();

    protected abstract L getLayoutManager();

    /**
     * 子类可复写该方法创建自己扩展的Adapter
     *
     * @return
     */
    protected A getAdapter() {
        if (adapter == null) {
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<? extends MyBaseAdapter> adpterClass = (Class<? extends MyBaseAdapter>) type.getActualTypeArguments()[1];
            try {
                adapter = (A) adpterClass.newInstance();
                adapter.init(getActivity(), getDataType());
                LogUtils.e("getAdapter  succeed to initialize  adpter   adapter=" + adapter);
            } catch (Exception e) {
                LogUtils.e("getAdapter  fail to initialize  adpter   e.getMessage()=" + e.getMessage());
                e.printStackTrace();
            }
        }
        return adapter;
    }

    @Override
    public int getViewLayout() {
        return R.layout.layout_common_recyclerview;
    }


    @Override
    protected void initView(Bundle savedInstanceState, Bundle args) {
        initViews();
    }


    private void initViews() {
        layoutManager = getLayoutManager();
        rv.setLayoutManager(layoutManager);
        adapter = getAdapter();

        adapter.bindToRecyclerView(rv);
        adapter.setEmptyView(R.layout.view_empty_list);
        adapter.openLoadAnimation();
        adapter.setOnLoadMoreListener(this, rv);
        adapter.setOnItemClickListener(this);
    }


    @Override
    protected void loadData(Bundle savedInstanceState) {
        refreshLayout.froceRefreshToState(true);
    }

    @Override
    public void showContentView(String url, BaseBean baseBean) {
        closeRefresh(refreshLayout);
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


    @Override
    public void onRefresh() {
        adapter.getData().clear();
        presenter.setNeedDialog(false);
        page = 1;
//        ProjectListUtil.getList(presenter,type, state, page);
    }


    @Override
    public void onLoadMoreRequested() {
        presenter.setNeedDialog(false);
        page++;
//        ProjectListUtil.getList(presenter,type, state, page);
    }


    @Override
    public void onError(ResponseInfo responseInfo) {
        if (page > 1) {
            page--;
        }
        closeRefresh(refreshLayout);
        super.onError(responseInfo);
    }


    /**
     * 子类可以复写该方法进行数据显示
     *
     * @param datas
     */
    protected void updateDataList(List<D> datas) {
        getAdapter().setNewData(datas);
        LogUtils.e("updateDataList   adapter=" + adapter + "      Thread=" + Thread.currentThread().getName() + "    datas=" + datas);
    }





}
