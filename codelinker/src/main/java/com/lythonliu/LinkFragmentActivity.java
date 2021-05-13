package com.lythonliu;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.widget.Toast;

import com.lythonliu.codelinker.R;


public class LinkFragmentActivity extends FragmentActivity implements LinkInterface{

    @Override // TODO: 2021/5/13 warning
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getPointerCount()==3){
            //"https://github.com/lythonliu/Dialog/blob/master/app/src/main/java/com/lythonliu/dialogdemo/MainActivity.java";
            //com.lythonliu.dialogdemo.MainActivity
//            Toast.makeText(this,getClass().getName()+getClass().getCanonicalName(),Toast.LENGTH_LONG).show();
            StringBuilder stringBuilder = new StringBuilder(getRepository());
            if ("".equals(getDirect())) { // TODO: 2021/5/13 warning
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                return true;
            }
            stringBuilder.append("/blob/master/"+getDirect()+"/src/main/java/");
            String[] split = getClass().getName().split("\\.");
            for (String s : split) {
                stringBuilder.append(s).append("/");
            }
            String str = stringBuilder.toString();
            String replace = str.substring(0,str.length()-1)+getFileType();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri content_url = Uri.parse(replace);
            intent.setData(content_url);
            startActivity(intent);
            return true;
        }
        return super.dispatchTouchEvent(event);
    }
    public String getRepository(){ return getString(R.string.repository); };

    public String getFileType() {
        return ".java";
    }
    @Override
    public String getDirect() {
        return "app";
    }
}
