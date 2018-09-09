package com.lythonliu.codelinkerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.lythonliu.LinkActivity;

public class TestLinkActivity extends LinkActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public String getAppName() {
        return BuildConfig.APP_NAME;
    }
}
