package com.example.liufan.weiyingapplication.myde.view;

import android.content.Context;
import android.content.res.TypedArray;

/**
 * Created by liufan on 2018/5/23.
 */

public class ThemeUtils {
    public static int getThemeColor(Context context, int attrRes) {
        TypedArray typedArray = context.obtainStyledAttributes(new int[]{attrRes});
        int color = typedArray.getColor(0, 0xffffff);
        typedArray.recycle();
        return color;
    }
}
