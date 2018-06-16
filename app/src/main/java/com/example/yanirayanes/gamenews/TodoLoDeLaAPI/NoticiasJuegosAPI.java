package com.example.yanirayanes.gamenews.TodoLoDeLaAPI;

import com.example.yanirayanes.gamenews.PlainOldJavaObjects.Noticia;
import com.example.yanirayanes.gamenews.PlainOldJavaObjects.Token;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

public interface NoticiasJuegosAPI {
    //Obteniendo token
    @POST("/login")
    @FormUrlEncoded
    Call<Token> savePost(@Field("User") String user, @Field("Password") String pass);

    @GET("/news")
    Call<List<Noticia>> getNews(
            @Header("Authorization:") String Token
    );
}
