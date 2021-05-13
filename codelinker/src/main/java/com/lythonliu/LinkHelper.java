package com.lythonliu;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class LinkHelper {

    public static boolean dispatch3(LinkInterface linkInterface) {
        StringBuilder stringBuilder = new StringBuilder(linkInterface.getRepository());
        if ("".equals(linkInterface.getDirect())) { // TODO: 2021/5/13 warning
            Toast.makeText(linkInterface.getContext(), "", Toast.LENGTH_SHORT).show();
            return true;
        }
        stringBuilder.append("/blob/master/"+linkInterface.getDirect()+"/src/main/java/");
        String[] split = linkInterface.getClass().getName().split("\\.");
        String[] var4 = split;
        int var5 = split.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String s = var4[var6];
            stringBuilder.append(s).append("/");
        }

        String str = stringBuilder.toString();
        String replace = str.substring(0, str.length() - 1) + linkInterface.getFileType();
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(replace);
        intent.setData(content_url);
        linkInterface.startActivity(intent);
        return false;
    }
}
