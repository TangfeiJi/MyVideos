package com.asdcce.ddgfd.modules.recycle.contract;

import com.asdcce.ddgfd.base.view.IView;
import com.asdcce.ddgfd.base.presenter.IPresenter;

/**
 * Author:JTF
 * Date :
 * Desc :
 */
public interface RecycleContract {
    //对于经常使用的关于UI的方法可以定义到IView中
    interface View extends IView {
        void responRecycle(boolean isLoadMore);
    }

    interface Presenter extends IPresenter<View> {
        void requestRecycle(boolean showViewAndLoadMore);
    }
}
