package com.coder4.clipboard.activity;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;

import com.coder4.clipboard.constant.IntentKeyConstant;
import com.coder4.clipboard.fragment.BaseFragment;

public class SingleFragmentActivity extends BaseActivity {

    private Fragment mFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 若为fragment intent，初始化fragment
        if (isFragmentIntent()) {
            // init and add fragment
            mFragment = getSupportFragmentManager().findFragmentByTag(getFragmentTag());
            if (mFragment == null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                mFragment = Fragment.instantiate(this, getFragmentClassName(),
                        getFragmentArguments());
                ft.add(android.R.id.content, mFragment, getFragmentTag()).commit();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mFragment instanceof BaseFragment) {
            BaseFragment baseFragment = (BaseFragment) mFragment;
            if (!baseFragment.onBackPressed()) {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }

    private String getFragmentClassName() {
        return getIntent().getStringExtra(IntentKeyConstant.FRAGMENT_CLASS_NAME);
    }

    private Bundle getFragmentArguments() {
        // Can be null
        return getIntent().getBundleExtra(IntentKeyConstant.FRAGMENT_ARGS);
    }

    private String getFragmentTag() {
        return getIntent().getStringExtra(IntentKeyConstant.FRAGMENT_TAG);
    }

    private boolean isFragmentIntent() {
        return getFragmentClassName() != null
                && getFragmentTag() != null;
    }
}
