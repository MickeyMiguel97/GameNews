package com.example.yanirayanes.gamenews.TodoLoDeLaAPI;

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
