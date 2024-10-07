package com.example.animalsguideproject.activitys;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animalsguideproject.MusicService;
import com.example.animalsguideproject.R;

public class MainActivity extends AppCompatActivity
{
    private Intent musicServiceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (musicServiceIntent == null) {
            musicServiceIntent = new Intent(this, MusicService.class);
            startService(musicServiceIntent);}
    }

    @Override
   protected void onDestroy() {
        stopService(musicServiceIntent);
        super.onDestroy();
    }


}
