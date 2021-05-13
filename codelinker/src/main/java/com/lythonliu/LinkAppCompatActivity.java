package com.lythonliu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.Toast;

import com.lythonliu.codelinker.BuildConfig;
import com.lythonliu.codelinker.R;


public class LinkAppCompatActivity extends AppCompatActivity implements LinkInterface{

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getPointerCount() != 3) {
            return super.dispatchTouchEvent(event);
        } else {
            if (LinkHelper.dispatch3(this)) return true;
            return true;
        }
    }

    public String getRepository(){ return getString(R.string.repository); }

    @Override
    public Context getContext() {
        return this;
    }

    public String getFileType() {
        return getString(R.string.postfix);
    }

    @Override
    public String getDirect() {
        return getString(R.string.app);
    }
}
