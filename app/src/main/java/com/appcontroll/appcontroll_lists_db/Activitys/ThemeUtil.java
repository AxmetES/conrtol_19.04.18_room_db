package com.appcontroll.appcontroll_lists_db.Activitys;

import android.app.Activity;
import android.content.Intent;

import com.appcontroll.appcontroll_lists_db.R;

public class ThemeUtil {
    private static int stheme;

    public final static int APP_THEME_RED =0;
    public final static int APP_THEME_BLUE =1;
    public final static int APP_THEME_YELLOW =2;

    public static void changeToTheme(Activity activity, int theme){
        stheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
        activity.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }

    public static void onActivityCreateSetTheme(Activity activity){
        switch (stheme){
            default:
                activity.setTheme(R.style.AppTheme);
                break;
            case APP_THEME_RED:
                activity.setTheme(R.style.AppTheme_red);
                break;
        }
    }
}
