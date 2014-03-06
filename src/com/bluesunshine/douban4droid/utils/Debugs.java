package com.bluesunshine.douban4droid.utils;

import android.content.Context;

/**
 * 
 * @author hao.wen <wenhao7704@gmail.com>
 * 
 */
public class Debugs {
	
    private static final boolean DEBUG = true;
    public static final int LONG = android.widget.Toast.LENGTH_LONG;
    public static final int SHORT = android.widget.Toast.LENGTH_SHORT;

    public static void d(String tag, String content) {
        if (DEBUG)
            android.util.Log.d(tag, content);
    }

    public static void e(String tag, String content) {
        if (DEBUG)
            android.util.Log.e(tag, content);
    }

    public static void w(String tag, String content) {
        if (DEBUG)
            android.util.Log.w(tag, content);
    }

    public static void v(String tag, String content) {
        if (DEBUG)
            android.util.Log.v(tag, content);
    }

    public static void i(String tag, String content) {
        if (DEBUG)
            android.util.Log.i(tag, content);
    }

    public static void out(String content) {
        if (DEBUG)
            System.out.println(content);
    }

    public static void toast(Context context, String message) {
        if (DEBUG)
            android.widget.Toast.makeText(context, message, SHORT).show();
    }

}
