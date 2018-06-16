package com.example.yanirayanes.gamenews.PlainOldJavaObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("Token")
    @Expose
    private String Token;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        this.Token = Token;
    }

    @Override
    public String toString() {
        return Token;
    }

    @SerializedName("_Id")
    @Expose
    private String Id;
    @SerializedName("Titulo")
    @Expose
    private String Titulo;
    @SerializedName("CoverImage")
    @Expose
    private String CoverImage;
    @SerializedName("Create_date")
    @Expose
    private String CreatedDate;
    @SerializedName("Descripcion")
    @Expose
    private String Descripcion;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getCoverImage() {
        return CoverImage;
    }

    public void setCoverImage(String coverImage) {
        CoverImage = coverImage;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
