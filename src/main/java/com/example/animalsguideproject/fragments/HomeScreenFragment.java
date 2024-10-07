package com.example.animalsguideproject.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.animalsguideproject.MusicService;
import com.example.animalsguideproject.R;

import java.util.Locale;

public class HomeScreenFragment extends Fragment {

    private boolean isHebrew = false;
    private Button btnStopMusic;
    private boolean isMusicPlaying = true;

    public HomeScreenFragment() {
        // Required empty public constructor
    }

    public static HomeScreenFragment newInstance(String param1, String param2) {
        HomeScreenFragment fragment = new HomeScreenFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public void setLanguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = getActivity().getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());

        getActivity().getSharedPreferences("AppSettingsPrefs", 0)
                .edit()
                .putString("AppLanguage", languageCode)
                .apply();

        refreshActivity();
    }

    private void refreshActivity() {
        Intent intent = getActivity().getIntent();
        getActivity().finish();
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_screen, container, false);

        btnStopMusic = view.findViewById(R.id.btnStopMusic);
        btnStopMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isMusicPlaying = !isMusicPlaying;
                Intent serviceIntent = new Intent(getActivity(), MusicService.class);

                if (isMusicPlaying) {
                    serviceIntent.setAction(MusicService.ACTION_PLAY);
                    btnStopMusic.setText(R.string.stop_music);
                } else {
                    serviceIntent.setAction(MusicService.ACTION_PAUSE);
                    btnStopMusic.setText(R.string.play_music);
                }
                getActivity().startService(serviceIntent);
            }
        });

        Button changeLang = view.findViewById(R.id.btnChangeLang);
        changeLang.setOnClickListener(v -> {
            SharedPreferences prefs = getActivity().getSharedPreferences("AppSettingsPrefs", 0);
            String currentLang = prefs.getString("AppLanguage", "en");

            if ("he".equals(currentLang)) {
                setLanguage("en");
            } else {
                setLanguage("he");
            }
        });

        Button buttonHomeToLog = view.findViewById(R.id.btnStrart);
        buttonHomeToLog.setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.action_homeScreenFragment_to_loginFragment));
        return view;
    }

}