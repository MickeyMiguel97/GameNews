package com.example.yanirayanes.gamenews.TodoLoDeLaAPI;

import com.example.yanirayanes.gamenews.PlainOldJavaObjects.Noticia;
import com.example.yanirayanes.gamenews.PlainOldJavaObjects.Token;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

public interface NoticiasJuegosAPI {
    //Obteniendo token
    @POST("/loging")
    @FormUrlEncoded
    Observable<Token> saveToken(@Field("user") String User,
                                @Field("password") String Password);

    //Fin de LogIn

    //Para las noticias
    //Lista de noticias
    @GET("/news")
    Call<Noticia[]> getNoticias(@Header("Authorization: ") String token);

    //Fin de noticias

    //
}
