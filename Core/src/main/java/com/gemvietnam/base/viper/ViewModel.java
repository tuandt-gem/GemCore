package com.gemvietnam.base.viper;

import com.gemvietnam.base.viper.interfaces.IView;
import com.gemvietnam.base.viper.interfaces.IViewModel;

/**
 * Base implement for ViewModel
 * Created by neo on 9/26/2016.
 */

public class ViewModel<V extends IView> implements IViewModel<V> {
    protected V mView;

    public ViewModel(V view) {
        mView = view;
    }

    @Override
    public void setView(V view) {
        mView = view;
    }
}
