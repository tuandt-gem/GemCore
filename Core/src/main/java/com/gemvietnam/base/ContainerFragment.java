package com.gemvietnam.base;

import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.IView;
import com.gemvietnam.base.viper.interfaces.IViewModel;
import com.gemvietnam.common.R;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Base Fragment
 * Created by neo on 3/22/2016.
 */
public abstract class ContainerFragment extends BaseFragment implements ContainerView {
    /**
     * Return layout resource id for activity
     * Override if you using other layout
     */
    @Override
    public int getLayoutId() {
        return R.layout.container;
    }

    public void addChildFragment(Fragment fragment) {
        addChildFragment(fragment, true);
    }

    public void addChildFragment(Fragment fragment, boolean addToBackStack) {
        addChildFragment(fragment, addToBackStack, fragment.getClass().getSimpleName());
    }

    public void addChildFragment(Fragment fragment, boolean addToBackStack, String tag) {
        addChildFragment(fragment, CoreDefault.FRAGMENT_CONTAINER_ID, addToBackStack, tag);
    }

    @Override
    protected void startPresent() {
        addChildFragment(onCreateFirstFragment(), false);
    }

    @Override
    public void addView(IView view) {
        if (view instanceof Fragment) {
            addChildFragment((Fragment) view);
        }
    }

    @Override
    public void setPresenter(IPresenter presenter) {
        // Do nothing
    }
}
