package com.example.kiran.myandroidbasics.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.kiran.myandroidbasics.R;

/**
 * Created by Kiran on 20-02-2017.
 * Unbounded Services in android
 */

public class HelloService extends Service {
    private final String TAG = HelloService.class.getSimpleName();
    private MediaPlayer mMediaPlayer;

    public HelloService() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate:");
        mMediaPlayer = MediaPlayer.create(this, R.raw.hare_krishna_hare_ram_ringtone);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mMediaPlayer.start();
//        return START_STICKY;
//        return START_NOT_STICKY;
        return START_STICKY_COMPATIBILITY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy:");
//        mMediaPlayer.stop();
        mMediaPlayer.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
