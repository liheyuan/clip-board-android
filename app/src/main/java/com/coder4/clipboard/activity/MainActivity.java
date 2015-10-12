package com.coder4.clipboard.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.coder4.clipboard.R;
import com.coder4.clipboard.fragment.TestFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
                launch(TestFragment.class);
                break;
            default:
                break;
        }
    }
}
