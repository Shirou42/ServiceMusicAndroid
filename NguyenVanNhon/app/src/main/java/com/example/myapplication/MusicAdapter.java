package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {
    private ArrayList<com.example.myapplication.Music> listMusic;
    private LayoutInflater layoutInflater;

    public MusicAdapter(Context ctx, ArrayList<com.example.myapplication.Music> listMusic) {
        this.layoutInflater = LayoutInflater.from(ctx);
        this.listMusic = listMusic;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_rcv, parent, false);
        return new MusicViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        String name = listMusic.get(position).getName();
        int img = listMusic.get(position).getImage();
        int mp3 = listMusic.get(position).getMp3();
        holder.tvMusiceName.setText(name);
        holder.imgMusic.setImageResource(img);
        holder.imgMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActitivyPlay.class);
                intent.putExtra("name", name);
                intent.putExtra("img", img);
                intent.putExtra("mp3", mp3);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMusic.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMusiceName;
        public ImageView imgMusic;
        public com.example.myapplication.MusicAdapter musicAdapter;
        public MusicViewHolder(@NonNull View itemView, com.example.myapplication.MusicAdapter musicAdapter) {
            super(itemView);
            tvMusiceName = itemView.findViewById(R.id.tvMusicName);
            imgMusic = itemView.findViewById(R.id.imgMusic);
            this.musicAdapter = musicAdapter;
        }
    }
}
