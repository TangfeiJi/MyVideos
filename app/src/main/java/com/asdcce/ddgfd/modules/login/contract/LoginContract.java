package com.asdcce.ddgfd.modules.login.contract;

import com.asdcce.ddgfd.base.view.IView;
import com.asdcce.ddgfd.base.presenter.IPresenter;
import com.asdcce.ddgfd.modules.bean.ConfigBean;
import com.asdcce.ddgfd.modules.bean.UserDetailsBean;
import com.asdcce.ddgfd.modules.login.bean.ContentBean;
import com.asdcce.ddgfd.modules.login.bean.LoginBean;

/**
 * Author:JTF
 * Date :
 * Desc :
 */
public interface LoginContract {
    //对于经常使用的关于UI的方法可以定义到IView中
    interface View extends IView {
        void loginRespon();

    }

    interface Presenter extends IPresenter<View> {
        void loginRequest();
    }
}
