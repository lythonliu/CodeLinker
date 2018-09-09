package com.lythonliu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.Toast;


public abstract class LinkAppCompatActivity extends AppCompatActivity{

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getPointerCount()==3){
            //"https://github.com/lythonliu/Dialog/blob/master/app/src/main/java/com/lythonliu/dialogdemo/MainActivity.java";
            //com.lythonliu.dialogdemo.MainActivity
            Toast.makeText(this,getClass().getName()+getClass().getCanonicalName(),Toast.LENGTH_LONG).show();
            StringBuilder stringBuilder = new StringBuilder("https://github.com/lythonliu/");
            stringBuilder.append(getAppName()).append("/blob/master/app/src/main/java/");
            String[] split = getClass().getName().split("\\.");
            for (String s : split) {
                stringBuilder.append(s).append("/");
            }
            String str = stringBuilder.toString();
            String replace = str.substring(0,str.length()-1)+ ".java";
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri content_url = Uri.parse(replace);
            intent.setData(content_url);
            startActivity(intent);
            return true;
        }
        return super.onTouchEvent(event);
    }
    public abstract String getAppName();
}
