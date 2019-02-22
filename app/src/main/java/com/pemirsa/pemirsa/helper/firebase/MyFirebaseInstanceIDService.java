package com.pemirsa.pemirsa.helper.firebase;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.iid.InstanceIdResult;
import com.pemirsa.pemirsa.helper.Config;


/**
 * Created by Ravi Tamada on 08/08/16.
 * www.androidhive.info
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = MyFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        Task<InstanceIdResult> refreshedToken = FirebaseInstanceId.getInstance().getInstanceId();

        // Saving reg id to shared preferences
        storeRegIdInPref(refreshedToken);

        // sending reg id to your server
        sendRegistrationToServer(refreshedToken);

        // Notify UI that registration has completed, so the progress indicator can be hidden.
        Intent registrationComplete = new Intent(Config.REGISTRATION_COMPLETE);
        registrationComplete.putExtra("token", String.valueOf(refreshedToken));
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
    }

    private void sendRegistrationToServer(final Task<InstanceIdResult> token) {
        // sending gcm token to server
        Log.e(TAG, "sendRegistrationToServer: " + token);
    }

    private void storeRegIdInPref(Task<InstanceIdResult> token) {
//        SharedPreferences pref = getApplicationContext().getSharedPreferences(Config.SHARED_PRED_NAME, MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putString(Config.TOKEN_FIREBASE_REG_ID, String.valueOf(token));
//        editor.apply();
//        Log.e(TAG, "token: " + token);
    }
}

