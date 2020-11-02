package com.asdcce.ddgfd.modules.home.contract;

import com.asdcce.ddgfd.base.presenter.IPresenter;
import com.asdcce.ddgfd.base.view.IView;
import com.asdcce.ddgfd.modules.bean.FriendsBean;
import com.asdcce.ddgfd.modules.bean.ProdusasctBean;
import com.asdcce.ddgfd.modules.bean.UserDetailsBean;

import java.util.List;

public interface HomeContract {
    interface View extends IView {
    }

    interface Presenter extends IPresenter<View> {
    }
}
