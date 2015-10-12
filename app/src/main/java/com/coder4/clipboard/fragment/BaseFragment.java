package com.coder4.clipboard.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lihy on 15/10/12.
 */
public abstract class BaseFragment extends Fragment {

    // parent view
    protected View parent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parent = inflater.inflate(getLayoutId(), container, false);
        return parent;
    }

    protected abstract int getLayoutId();

    // Add back press for fragment
    public boolean onBackPressed() {
        // return true for not calling any other back press
        return true;
    }
}
