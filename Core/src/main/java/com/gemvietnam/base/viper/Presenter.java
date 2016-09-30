package com.gemvietnam.base.viper;

import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.IRouter;
import com.gemvietnam.base.viper.interfaces.IView;
import com.gemvietnam.base.viper.interfaces.IViewModel;

import android.app.Activity;

/**
 * Base implements for presenters
 * Created by neo on 14/03/2016.
 */
public abstract class Presenter<R extends IRouter, VM extends IViewModel, V extends IView,
        I extends IInteractor> implements IPresenter<R, VM, V, I> {
    protected V mView;
    protected R mRouter;
    protected I mInteractor;
    protected VM mViewModel;

    @SuppressWarnings("unchecked")
    public Presenter(R router) {
        mRouter = router;
        mInteractor = onCreateInteractor();
        mView = onCreateView();
        mViewModel = onCreateViewModel(mView);

        mView.setPresenter(this);

        mViewModel.setView(mView);
    }


    @Override
    public Activity getViewContext() {
        return mView.getViewContext();
    }

    @Override
    public V getView() {
        return mView;
    }
}
