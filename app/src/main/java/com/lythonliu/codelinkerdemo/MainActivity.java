package com.lythonliu.codelinkerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.lythonliu.codelinkerdemo.R.layout.activity_main);
    }

    public void startTestLinkActivity(View view) {
        Intent intent  = new Intent(this,TestLinkActivity.class);
        startActivity(intent);
    }
}
