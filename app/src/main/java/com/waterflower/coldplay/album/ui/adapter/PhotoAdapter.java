package com.waterflower.coldplay.album.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.waterflower.coldplay.R;
import com.waterflower.coldplay.album.bean.NewListBean;
import com.waterflower.coldplay.waterflower.adapter.MyBaseAdapter;
import com.waterflower.coldplay.waterflower.basic.manager.ImageManager;


/**
 * Author : WaterFlower.
 * Created on 2017/8/24.
 * Desc :  新房适配器
 */

public class PhotoAdapter extends MyBaseAdapter<NewListBean.DataBean> {

    private Context context;

    @Override
    protected int getLayoutResId() {
        return R.layout.item_album;
    }

    public PhotoAdapter() {
    }

    public PhotoAdapter(Context context) {
        super();
        this.context=context;

    }


//    参数
//            说明
//    project_name
//            项目名称
//    project_id
//            项目id
//    project_key
//            项目key
//    estate_type
//            物业类型
//    estate_price
//            项目均价
//    upload_id
//            图片
//    region_name
//            区域
//    AA
//            项目分润
//    AB
//            中介分润

    @Override
    protected void convert(BaseViewHolder helper, NewListBean.DataBean item) {
        helper.setText(R.id.tvName, item.project_name)
                .setText(R.id.tvCount, item.AA);

        ImageManager.load(context,item.upload_id,R.mipmap.place_holder, ((ImageView) helper.getView(R.id.ivAlbum)));
    }



}
