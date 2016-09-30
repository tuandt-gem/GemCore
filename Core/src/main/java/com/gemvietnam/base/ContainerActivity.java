package com.gemvietnam.base;

import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.IView;
import com.gemvietnam.base.viper.interfaces.IViewModel;
import com.gemvietnam.common.R;

import android.support.v4.app.FragmentManager;


/**
 * Base Fragment
 * Created by neo on 3/22/2016.
 */
public abstract class ContainerActivity extends BaseActivity implements ContainerView {
    /**
     * Return layout resource id for activity
     * Override if you using other layout
     */
    @Override
    public int getLayoutId() {
        return R.layout.container;
    }

    @Override
    public void addView(IView view) {
        if (view instanceof BaseFragment) {
            addFragment((BaseFragment) view, true);
        }
    }

    public void addFragment(BaseFragment fragment, boolean addToBackStack) {
        addFragment(fragment, addToBackStack, fragment.getClass().getSimpleName());
    }

    public void addFragment(BaseFragment fragment, boolean addToBackStack, String tag) {
        addFragment(CoreDefault.FRAGMENT_CONTAINER_ID, fragment, addToBackStack, tag);
    }

    @Override
    public void initLayout() {
        addFragment(onCreateFirstFragment(), false);
    }

    @Override
    public void setPresenter(IPresenter presenter) {
        // Nothing to do
    }
}
