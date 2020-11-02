package com.asdcce.ddgfd.modules.home.adapter;


import android.content.Context;

import androidx.annotation.Nullable;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.modules.recycle.bean.RecycleBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;


/**
 * Author:JTF
 * Date :
 * Desc :
 */

public class HomeRecomAdapter extends BaseQuickAdapter<RecycleBean, BaseViewHolder> implements LoadMoreModule {

    private Context mContext;

    public HomeRecomAdapter(Context context, @Nullable List<RecycleBean> data) {
        super(R.layout.item_home_recom, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, RecycleBean item) {

        // helper.setText(R.id.txtName,item.getPname())
//                .setText(R.id.txtPrice,item.getMaximum_amount())
//                .setText(R.id.txtRate,item.getMin_algorithm())
//                .setText(R.id.txtDis,item.getIntroduction());
//        GlideImageLoader.load(mContext,item.getLogo(),helper.getView(R.id.imgIcon));
//
//    LinearLayout content_layout=helper.getView(R.id.content_layout);
//        content_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mContext.startActivity(new Intent(mContext, ProductActivity.class));
//            }
//        });
    }
}