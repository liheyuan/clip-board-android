package com.coder4.clipboard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.coder4.clipboard.constant.IntentKeyConstant;

public class BaseActivity extends FragmentActivity {

    // Launch a fragment by using an activity
    public void launch(Class<? extends Fragment> fragment) {
        launch(fragment, null, 0);
    }

    // Launch a fragment by using an activity
    public void launch(Class<? extends Fragment> fragment, Bundle fragmentArgs) {
        launch(fragment, fragmentArgs, 0);
    }

    // Launch a fragment by using an activity
    public void launch(Class<? extends Fragment> fragment,
            Bundle fragmentArgs, int reqCode) {
        Intent intent = new Intent(this, SingleFragmentActivity.class);
        // set fragment name, bundle
        intent.putExtra(IntentKeyConstant.FRAGMENT_CLASS_NAME, fragment.getName());
        intent.putExtra(IntentKeyConstant.FRAGMENT_TAG, fragment.getSimpleName());
        if (fragmentArgs != null) {
            intent.putExtra(IntentKeyConstant.FRAGMENT_ARGS, fragmentArgs);
        }
        // start
        if (reqCode == 0) {
            startActivity(intent);
        } else {
            startActivityForResult(intent, reqCode);
        }
    }
}
