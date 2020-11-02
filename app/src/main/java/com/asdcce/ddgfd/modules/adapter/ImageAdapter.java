package com.asdcce.ddgfd.modules.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.modules.recycle.bean.RecycleBean;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class ImageAdapter extends BannerAdapter<RecycleBean, ImageAdapter.BannerViewHolder> {
private Context mContext;
    public ImageAdapter(Context context,List<RecycleBean> mDatas) {
        super(mDatas);
        mContext=context;
    }

    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerViewHolder(imageView);
    }

    @Override
    public void onBindView(BannerViewHolder holder, RecycleBean data, int position, int size) {
        holder.imageView.setBackgroundResource(R.mipmap.logo);
//        holder.imageView.setImageResource(data.imageRes);

    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public BannerViewHolder(@NonNull ImageView view) {
            super(view);
            this.imageView = view;
        }
    }
}