package com.classy.class_2021a_and_10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("pttt", "onReceive");
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)){
            Log.d("pttt", "A" + System.currentTimeMillis());
            Log.d("pttt", "Internet Connection: " + hasInternetConnection(context));
            Log.d("pttt", "B" + System.currentTimeMillis());

        }
    }

    public static boolean isInternetAvailable2() {
        try {
            String command = "ping -c 1 google.com";
            return (Runtime.getRuntime().exec (command).waitFor() == 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    public static boolean hasInternetConnection(final Context context) {
        final ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            final Network network = connectivityManager.getActiveNetwork();
            final NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(network);
            return capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED);
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
    }
}