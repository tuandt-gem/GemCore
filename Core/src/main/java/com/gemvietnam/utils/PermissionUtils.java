package com.gemvietnam.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

/**
 * Check, request permission utils
 * Created by neo on 7/26/2016.
 */
public class PermissionUtils {

    public static boolean checkToRequest(Activity activity, String permission, int requestCode) {
        int permissionCheck = ContextCompat.checkSelfPermission(activity, permission);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                Log.i("PermissionUtils", "Should show request permission rationale");
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
            }

            return false;
        } else {
            return true;
        }
    }

    public static boolean isPermissionGranted(Activity activity, String permission) {
        return ContextCompat.checkSelfPermission(activity, permission) ==
                PackageManager.PERMISSION_GRANTED;
    }
}
