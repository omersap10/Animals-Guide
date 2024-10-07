package com.example.animalsguideproject;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import androidx.annotation.Nullable;

public class MusicService extends Service {
    private MediaPlayer player;
    public static final String ACTION_PLAY = "ACTION_PLAY";
    public static final String ACTION_PAUSE = "ACTION_PAUSE";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            if (ACTION_PLAY.equals(action)) {
                if (player == null) {
                    player = MediaPlayer.create(this, R.raw.junglemusic2);
                    player.setLooping(true);
                }
                if (!player.isPlaying()) {
                    player.start();
                }
            } else if (ACTION_PAUSE.equals(action)) {
                if (player != null && player.isPlaying()) {
                    player.pause();
                }
            }
        } else {
            if (player == null) {
                player = MediaPlayer.create(this, R.raw.junglemusic2);
                player.setLooping(true);
            }
            if (!player.isPlaying()) {
                player.start();
            }
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}