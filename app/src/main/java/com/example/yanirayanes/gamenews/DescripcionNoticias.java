package com.example.yanirayanes.gamenews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DescripcionNoticias extends AppCompatActivity {

    TextView Juego,Titulo,Cuerpo;
    ImageView Img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_noticias);

        Juego =  findViewById(R.id.juego);
        Titulo =  findViewById(R.id.titulo);
        Cuerpo =  findViewById(R.id.cuerpo);
        Img = findViewById(R.id.thumbnail);

        Intent intent =  getIntent();
        String title =  intent.getExtras().getString("Titulo");
        String game =  intent.getExtras().getString("Juego");
        String body =  intent.getExtras().getString("Cuerpo");
        String img = intent.getExtras().getString("Img");

        Juego.setText(game);
        Titulo.setText(title);
        this.Cuerpo.setText(body);
        Picasso.get().load(img).into(this.Img);
    }
}
