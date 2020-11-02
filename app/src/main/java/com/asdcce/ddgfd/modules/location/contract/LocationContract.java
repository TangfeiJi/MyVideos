package com.asdcce.ddgfd.modules.location.contract;

import com.asdcce.ddgfd.base.presenter.IPresenter;
import com.asdcce.ddgfd.base.view.IView;
import com.asdcce.ddgfd.core.event.LocationEvent;
import com.asdcce.ddgfd.modules.bean.ProdusasctBean;


import java.util.List;

public interface LocationContract {
    interface View extends IView {


    }

    interface Presenter extends IPresenter<View> {
        void requestUpload(String token, String lon, String lat);
    }
}
