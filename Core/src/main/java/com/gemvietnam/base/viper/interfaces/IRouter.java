package com.gemvietnam.base.viper.interfaces;


import android.support.v4.app.Fragment;

/**
 * Base Router
 * Created by neo on 8/29/2016.
 */
public interface IRouter {
    void present();

    IView getView();
//
//    V onCreatePresenter();

    Fragment getFragment();
}
