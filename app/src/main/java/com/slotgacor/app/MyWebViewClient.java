package com.slotgacor.app;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.URLUtil;
import android.content.pm.PackageManager;
import android.content.Context;

class MyWebViewClient extends WebViewClient {
    private Context context;
    private boolean appInstalledOrNot(String uri) {
        /**
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
        }
         */

        return false;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (URLUtil.isNetworkUrl(url)) {
            return false;
        }
        if (appInstalledOrNot(url)) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            this.context.startActivity(intent);
        } else {
            // do something if app is not installed
        }
        return true;
    }
}
