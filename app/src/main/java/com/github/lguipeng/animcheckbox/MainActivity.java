package com.github.lguipeng.animcheckbox;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.sax.EndTextElementListener;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.github.lguipeng.library.animcheckbox.AnimCheckBox;

public class MainActivity extends AppCompatActivity implements AnimCheckBox.OnCheckedChangeListener {
    private AnimCheckBox mAnimCheckBox1, mAnimCheckBox2;
	private LinearLayout mRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
	    mRootLayout = (LinearLayout) findViewById(R.id.main_activity_root);
        mAnimCheckBox1 = (AnimCheckBox) findViewById(R.id.checkbox_1);
        mAnimCheckBox2 = (AnimCheckBox) findViewById(R.id.checkbox_2);
        mAnimCheckBox1.setOnCheckedChangeListener(this);
        mAnimCheckBox2.setOnCheckedChangeListener(this);

	    final AnimCheckBox animCheckBox = new AnimCheckBox(getApplication());
	    mRootLayout.addView(animCheckBox);

	    animCheckBox.setStrokeColor(Color.CYAN);
	    animCheckBox.setCircleColor(Color.BLACK);
	    animCheckBox.setStrokeWidth(24);
	    animCheckBox.setChecked(true, false);
	    animCheckBox.setAnimationDuration(1500);
    }

    @Override
    public void onChange(AnimCheckBox view, boolean checked) {
        switch (view.getId()) {
            case R.id.checkbox_1:
                Log.d("MainActivity", "checkbox_1 --> " + checked);
                break;
            case R.id.checkbox_2:
                Log.d("MainActivity", "checkbox_2 --> " + checked);
                break;
        }
    }
}
