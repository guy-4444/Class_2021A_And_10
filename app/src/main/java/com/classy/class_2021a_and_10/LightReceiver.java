package com.classy.class_2021a_and_10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LightReceiver extends BroadcastReceiver {

    public static final String EXTRA_LIGHT = "EXTRA_LIGHT";
    public static final String ACTION_LIGHT = "ACTION_LIGHT";

    private CallBack_light callBack_light;

    public interface CallBack_light {
        void light(float value);
    }


    public LightReceiver(CallBack_light callBack_light) {
        this.callBack_light = callBack_light;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        float val = intent.getFloatExtra(EXTRA_LIGHT, 0);

        if (callBack_light != null) {
            callBack_light.light(val);
        }
    }
}
