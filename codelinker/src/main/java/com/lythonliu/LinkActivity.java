package com.lythonliu;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import android.view.MotionEvent;

import com.lythonliu.codelinker.R;

public class LinkActivity extends Activity implements LinkInterface {
    public LinkActivity() {
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getPointerCount() != 3) {
            return super.dispatchTouchEvent(event);
        } else {
            if (LinkHelper.dispatch3(this)) return true;
            return true;
        }
    }



    public String getRepository(){ return getString(R.string.repository); }

    @Override
    public Context getContext() {
        return this;
    }

    public String getFileType() {
        return getString(R.string.postfix);
    }

    @Override
    public String getDirect() {
        return getString(R.string.app);
    }

    @Override
    public String getBranch() {
        return getString(R.string.branch);
    }

    @Override
    public boolean isRelease() {
        return getResources().getBoolean(R.bool.is_release);
    }

    /*example public String getDirect() {
        String className = getComponentName().getClassName();
        String feature = "";
        if (11<className.length()&&className.indexOf("feature")>11)
        feature = ("feature." + className.subSequence(11, className.indexOf("feature") - 1)).replace(".", "/");
        LogUtils.dTag("getDirect",className,feature);
        return feature;
    }
*/
}
