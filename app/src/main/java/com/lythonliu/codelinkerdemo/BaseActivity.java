package com.lythonliu.codelinkerdemo;

import com.lythonliu.LinkAppCompatActivity;

public class BaseActivity extends LinkAppCompatActivity {
    @Override
    public String getRepository() {
        return BuildConfig.repository;
    }
}
