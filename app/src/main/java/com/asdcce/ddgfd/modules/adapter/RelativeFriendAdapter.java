package com.asdcce.ddgfd.modules.adapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.modules.bean.FriendsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;


import java.util.List;

public class RelativeFriendAdapter extends BaseQuickAdapter<FriendsBean, BaseViewHolder> {

    public RelativeFriendAdapter(@Nullable List<FriendsBean> data) {

        super(R.layout.item_rcv_recycleview, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, FriendsBean item) {




//        helper.addOnClickListener(R.id.rlContent);

    }
}
