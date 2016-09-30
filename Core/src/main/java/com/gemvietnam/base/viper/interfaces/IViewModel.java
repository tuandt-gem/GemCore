package com.gemvietnam.base.viper.interfaces;

/**
 * Base ViewModel interface
 * Created by neo on 9/26/2016.
 */

public interface IViewModel<V extends IView>{
    void setView(V view);
}
