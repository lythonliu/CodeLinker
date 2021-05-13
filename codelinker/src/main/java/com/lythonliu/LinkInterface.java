package com.lythonliu;

import android.content.Context;
import android.content.Intent;

public interface LinkInterface {
    String getDirect();

    String getRepository();

    Context getContext();

    String getFileType();

    void startActivity(Intent intent);
}
