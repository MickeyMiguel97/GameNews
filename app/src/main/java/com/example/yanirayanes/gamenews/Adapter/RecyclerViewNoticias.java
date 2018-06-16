package com.example.yanirayanes.gamenews.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yanirayanes.gamenews.PlainOldJavaObjects.Noticia;
import com.example.yanirayanes.gamenews.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewNoticias extends RecyclerView.Adapter<RecyclerViewNoticias.MyViewHolder>{

    private List<Noticia> noticia;

    public RecyclerViewNoticias(List<Noticia> noticia){
        this.noticia = noticia;
    }

    @Override
    public int getItemCount(){
        return noticia.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_noticias,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position){
        holder.Titulo.setText(noticia.get(position).getTitulo());
        Picasso.get()
                .load(noticia.get(position).getCoverImage())
                .fit().into(holder.JuegoImg);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Titulo;
        ImageView JuegoImg;
        public MyViewHolder(View itemView){
            super(itemView);
            Titulo = itemView.findViewById(R.id.txt_title);
            JuegoImg = itemView.findViewById(R.id.img_game);
        }
    }


}
