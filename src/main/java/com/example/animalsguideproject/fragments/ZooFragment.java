package com.example.animalsguideproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalsguideproject.MusicService;
import com.example.animalsguideproject.R;
import com.example.animalsguideproject.animals.AnimalsData;
import com.example.animalsguideproject.animals.CustomeAdapter;

import java.util.ArrayList;

public class ZooFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<AnimalsData> dataSet;
    private CustomeAdapter adapter;
    private Button btnStopMusic;
    private boolean isMusicPlaying = true;

    public ZooFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataSet();
    }

    private void initDataSet() {
        if (getActivity() != null) {
            dataSet = new ArrayList<>();

            dataSet.add(new AnimalsData(R.string.animal_name_lion, R.string.animal_desc_lion, R.drawable.lion));
            dataSet.add(new AnimalsData(R.string.animal_name_elephant, R.string.animal_desc_elephant, R.drawable.elephant));
            dataSet.add(new AnimalsData(R.string.animal_name_giraffe, R.string.animal_desc_giraffe, R.drawable.giraffe));
            dataSet.add(new AnimalsData(R.string.animal_name_panda, R.string.animal_desc_panda, R.drawable.panda));
            dataSet.add(new AnimalsData(R.string.animal_name_tiger, R.string.animal_desc_tiger, R.drawable.tiger));
            dataSet.add(new AnimalsData(R.string.animal_name_bear, R.string.animal_desc_bear, R.drawable.bear));
            dataSet.add(new AnimalsData(R.string.animal_name_rhino, R.string.animal_desc_rhino, R.drawable.rhino));
            dataSet.add(new AnimalsData(R.string.animal_name_hippo, R.string.animal_desc_hippo, R.drawable.hippo));
            dataSet.add(new AnimalsData(R.string.animal_name_wolf, R.string.animal_desc_wolf, R.drawable.wolf));
            dataSet.add(new AnimalsData(R.string.animal_name_monkey, R.string.animal_desc_monkey, R.drawable.monkey));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zoo, container, false);
        String email = getArguments().getString("Email");
        ((android.widget.TextView) view.findViewById(R.id.txtViewUserName)).setText(email);

        btnStopMusic = view.findViewById(R.id.btnStopMusic3);
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

        recyclerView = view.findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new CustomeAdapter(getContext(), dataSet);
        recyclerView.setAdapter(adapter);

        return view;
    }
}

