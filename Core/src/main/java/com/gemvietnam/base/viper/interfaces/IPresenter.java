package com.gemvietnam.base.viper.interfaces;

import com.gemvietnam.base.viper.ViewFragment;

import android.app.Activity;

/**
 * Base Presenter
 * Created by neo on 2/5/2016.
 */
public interface IPresenter<R extends IRouter, VM extends IViewModel, V extends IView, I extends
        IInteractor> {
    Activity getViewContext();
    void start();

    V getView();
    I onCreateInteractor();
    VM onCreateViewModel(V view);
    V onCreateView();
}
