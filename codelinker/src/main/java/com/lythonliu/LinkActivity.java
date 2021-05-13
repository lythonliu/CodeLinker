package com.lythonliu;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.widget.Toast;

import com.lythonliu.codelinker.R;

public class LinkActivity extends Activity implements LinkInterface {
    public LinkActivity() {
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getPointerCount() != 3) {
            return super.dispatchTouchEvent(event);
        } else {
//            Toast.makeText(this, this.getClass().getName() + this.getClass().getCanonicalName(), 1).show();
            StringBuilder stringBuilder = new StringBuilder(getRepository());
            if ("".equals(getDirect())) { // TODO: 2021/5/13 warning
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                return true;
            }
            stringBuilder.append("/blob/master/"+getDirect()+"/src/main/java/");
            String[] split = this.getClass().getName().split("\\.");
            String[] var4 = split;
            int var5 = split.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String s = var4[var6];
                stringBuilder.append(s).append("/");
            }

            String str = stringBuilder.toString();
            String replace = str.substring(0, str.length() - 1) + getFileType();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri content_url = Uri.parse(replace);
            intent.setData(content_url);
            this.startActivity(intent);
            return true;
        }
    }

    public String getFileType() {
        return ".java";
    }

    public String getRepository(){ return getString(R.string.repository); };

    /*example public String getDirect() {
        String className = getComponentName().getClassName();
        String feature = "";
        if (11<className.length()&&className.indexOf("feature")>11)
        feature = ("feature." + className.subSequence(11, className.indexOf("feature") - 1)).replace(".", "/");
        LogUtils.dTag("getDirect",className,feature);
        return feature;
    }
*/
    @Override
    public String getDirect() {
        return "app";
    }
}
