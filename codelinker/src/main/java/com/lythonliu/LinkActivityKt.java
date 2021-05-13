package com.lythonliu;


import com.lythonliu.codelinker.R;

public abstract class LinkActivityKt extends LinkActivity {
    @Override
    public String getFileType() {
        return getString(R.string.postfix2);
    }
}
