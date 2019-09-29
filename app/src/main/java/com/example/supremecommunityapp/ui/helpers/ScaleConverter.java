package com.example.supremecommunityapp.ui.helpers;

import android.content.Context;

public class ScaleConverter {

    public static float pxFromDp(final int pixels, final Context context){
        return pixels / context.getResources().getDisplayMetrics().density;
    }

    public static float dpFromPx(final float dp, final Context context) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
