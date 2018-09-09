package com.lythonliu.codelinker;

import com.lythonliu.LinkAppCompatActivity;

public class BaseActivity extends LinkAppCompatActivity {
    @Override
    public String getAppName() {
        return BuildConfig.APP_NAME;
    }
}
