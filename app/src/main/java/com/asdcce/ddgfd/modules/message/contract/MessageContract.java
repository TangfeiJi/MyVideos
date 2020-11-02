package com.asdcce.ddgfd.modules.message.contract;

import com.asdcce.ddgfd.base.presenter.IPresenter;
import com.asdcce.ddgfd.base.view.IView;

public interface MessageContract {
    interface View extends IView {


    }

    interface Presenter extends IPresenter<View> {
        void requestUpload(String token, String lon, String lat);
    }
}
