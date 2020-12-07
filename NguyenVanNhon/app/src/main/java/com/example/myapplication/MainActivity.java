package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Music> listMusic;
    private MusicAdapter musicAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        listMusic = new ArrayList<>();
        listMusic.add(new Music("Big city boy", R.raw.bigcityboy, R.drawable.bicityboi));
        listMusic.add(new Music("Krazy", R.raw.krazy, R.drawable.krazy));
        listMusic.add(new Music("Một cú lừa", R.raw.bigcityboy, R.drawable.bichp));
        listMusic.add(new Music("Big city boy", R.raw.bigcityboy, R.drawable.sontung));
        listMusic.add(new Music("Big city boy", R.raw.bigcityboy, R.drawable.bicityboi));
        listMusic.add(new Music("Krazy", R.raw.krazy, R.drawable.krazy));
        listMusic.add(new Music("Một cú lừa", R.raw.bigcityboy, R.drawable.bichp));
        listMusic.add(new Music("Big city boy", R.raw.bigcityboy, R.drawable.sontung));


        recyclerView = findViewById(R.id.rcv);

        musicAdapter = new MusicAdapter(this, listMusic);

        recyclerView.setAdapter(musicAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}