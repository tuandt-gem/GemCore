package com.gemvietnam.base.viper;

import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.IRouter;
import com.gemvietnam.base.viper.interfaces.IView;

import android.support.v4.app.Fragment;

/**
 * Base Router
 * Created by neo on 8/29/2016.
 */
public abstract class Router<P extends IPresenter> implements IRouter {
    protected P mPresenter;
    protected ContainerView mContainerView;

    public Router(ContainerView containerView) {
        mContainerView = containerView;
        mPresenter = onCreatePresenter();
    }

    protected abstract P onCreatePresenter();

    @Override
    public void present() {
        mContainerView.addView(mPresenter.getView());
    }

    @Override
    public IView getView() {
        return mPresenter.getView();
    }

    @Override
    public Fragment getFragment() {
        return getView() instanceof Fragment ? (Fragment) getView() : null;
    }
}
