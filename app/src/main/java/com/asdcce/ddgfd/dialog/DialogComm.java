package com.asdcce.ddgfd.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.asdcce.ddgfd.R;
import com.lxj.xpopup.animator.PopupAnimator;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.interfaces.OnCancelListener;
import com.lxj.xpopup.interfaces.OnConfirmListener;

public class DialogComm extends CenterPopupView implements View.OnClickListener {
    private String cancel,confirm,content;
    OnCancelListener cancelListener;
    OnConfirmListener confirmListener;
    TextView tv_confirm,tv_cancel,tv_content;
    //注意：自定义弹窗本质是一个自定义View，但是只需重写一个参数的构造，其他的不要重写，所有的自定义弹窗都是这样。
    public DialogComm(@NonNull Context context,String content,String confirm,String cancel,OnConfirmListener confirmListener,OnCancelListener cancelListener) {
        super(context);
        this.cancel=cancel;
        this.confirm=confirm;
        this.content=content;
        this.cancelListener=cancelListener;
        this.confirmListener=confirmListener;

    }
    // 返回自定义弹窗的布局
    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_comm;
    }
    // 执行初始化操作，比如：findView，设置点击，或者任何你弹窗内的业务逻辑
    @Override
    protected void onCreate() {
        super.onCreate();
         tv_confirm=findViewById(R.id.tv_confirm);
         tv_cancel=findViewById(R.id.tv_cancel);
         tv_content=findViewById(R.id.tv_content);
        tv_confirm.setText(confirm);
        tv_cancel.setText(cancel);
        tv_content.setText(content);
        tv_cancel.setOnClickListener(this);
        tv_confirm.setOnClickListener(this);
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
        if (v == tv_cancel) {
            if (cancelListener != null) cancelListener.onCancel();
            dismiss();
        } else if (v == tv_confirm) {
            if (confirmListener != null) confirmListener.onConfirm();
            if (popupInfo.autoDismiss) dismiss();
        }
    }
}