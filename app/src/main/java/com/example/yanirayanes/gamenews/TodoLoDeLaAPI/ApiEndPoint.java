package com.example.yanirayanes.gamenews.TodoLoDeLaAPI;

public class ApiEndPoint {

    public ApiEndPoint(){}

    public static final String ENDPOINT = "http://gamenewsuca.herokuapp.com/";

    public static NoticiasJuegosAPI getGameNewsAPI(){
        return AdaptacionDelCliente.getClient(ENDPOINT).create(NoticiasJuegosAPI.class);
    }
}
