package com.lythonliu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.widget.Toast;

public abstract class LinkActivity extends Activity {
    public LinkActivity() {
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getPointerCount() != 3) {
            return super.onTouchEvent(event);
        } else {
            Toast.makeText(this, this.getClass().getName() + this.getClass().getCanonicalName(), 1).show();
            StringBuilder stringBuilder = new StringBuilder("https://github.com/lythonliu/");
            stringBuilder.append(this.getAppName()).append("/blob/master/app/src/main/java/");
            String[] split = this.getClass().getName().split("\\.");
            String[] var4 = split;
            int var5 = split.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String s = var4[var6];
                stringBuilder.append(s).append("/");
            }

            String str = stringBuilder.toString();
            String replace = str.substring(0, str.length() - 1) + ".java";
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri content_url = Uri.parse(replace);
            intent.setData(content_url);
            this.startActivity(intent);
            return true;
        }
    }

    public abstract String getAppName();
}
