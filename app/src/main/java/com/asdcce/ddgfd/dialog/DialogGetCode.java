package com.asdcce.ddgfd.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.asdcce.ddgfd.R;
import com.lxj.xpopup.animator.PopupAnimator;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.interfaces.OnCancelListener;
import com.lxj.xpopup.interfaces.OnConfirmListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DialogGetCode extends CenterPopupView implements View.OnClickListener {
    DialogGetCodeListener confirmListener;
    TextView tvNext;
    String code="";

    //注意：自定义弹窗本质是一个自定义View，但是只需重写一个参数的构造，其他的不要重写，所有的自定义弹窗都是这样。
    public DialogGetCode(@NonNull Context context, DialogGetCodeListener confirmListener) {
        super(context);
        this.confirmListener = confirmListener;

    }

    // 返回自定义弹窗的布局
    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_get_code;
    }

    // 执行初始化操作，比如：findView，设置点击，或者任何你弹窗内的业务逻辑
    @Override
    protected void onCreate() {
        super.onCreate();
        List<Integer> imgList = new ArrayList<>();
        imgList.add(1);
        imgList.add(1);
        imgList.add(1);
        imgList.add(1);
        imgList.add(1);
        imgList.add(1);
        List<ImageView> viewList = new ArrayList<>();
        viewList.add(findViewById(R.id.imgCode1));
        viewList.add(findViewById(R.id.imgCode2));
        viewList.add(findViewById(R.id.imgCode3));
        viewList.add(findViewById(R.id.imgCode4));
        viewList.add(findViewById(R.id.imgCode5));
        viewList.add(findViewById(R.id.imgCode6));
        for (int i = 0; i < imgList.size(); i++) {
            int randomNum = new Random().nextInt(9);
            viewList.get(i).setImageResource(imgList.get(randomNum));
            code+=randomNum+"";
        }
        tvNext = findViewById(R.id.tvNext);
        tvNext.setOnClickListener(this);
    }

    // 设置最大宽度，看需要而定
    @Override
    protected int getMaxWidth() {
        return super.getMaxWidth();
    }

    // 设置最大高度，看需要而定
    @Override
    protected int getMaxHeight() {
        return super.getMaxHeight();
    }

    // 设置自定义动画器，看需要而定
    @Override
    protected PopupAnimator getPopupAnimator() {
        return super.getPopupAnimator();
    }

    /**
     * 弹窗的宽度，用来动态设定当前弹窗的宽度，受getMaxWidth()限制
     *
     * @return
     */
    protected int getPopupWidth() {
        return 0;
    }

    /**
     * 弹窗的高度，用来动态设定当前弹窗的高度，受getMaxHeight()限制
     *
     * @return
     */
    protected int getPopupHeight() {
        return 0;
    }

    @Override
    public void onClick(View v) {
        if (v == tvNext) {
            if (confirmListener != null) confirmListener.onConfirm(code);
            if (popupInfo.autoDismiss) dismiss();
        }
    }
}