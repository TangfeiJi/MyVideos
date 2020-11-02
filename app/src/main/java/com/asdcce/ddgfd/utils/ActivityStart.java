package com.asdcce.ddgfd.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.asdcce.ddgfd.R;
import com.asdcce.ddgfd.modules.login.ui.activity.LoginActivity;

public class ActivityStart {


    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            activity.overridePendingTransition(R.anim.swipeback_activity_open_bottom_in,
                    R.anim.swipeback_activity_open_top_out);
        }
    }
}
