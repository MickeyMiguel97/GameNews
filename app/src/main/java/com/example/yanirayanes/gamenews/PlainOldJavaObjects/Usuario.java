package com.example.yanirayanes.gamenews.PlainOldJavaObjects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

@Entity(tableName = "usuarios")
public class Usuario {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "_ID")
    private String Id;
    @ColumnInfo(name = "User")
    private String NombreUsuario;
    @ColumnInfo(name = "Password")
    private String Contra;
    @Ignore
    @ColumnInfo(name = "NoticiasFav")
    private List<String> favoritos =null;

    public Usuario(){}

    public Usuario(@NonNull String Id, String NombreUsuario, String Contra){
        this.Id = Id;
        this.NombreUsuario = NombreUsuario;
        this.Contra = Contra;
    }

    @NonNull
    public String getId(){return Id;}

    public void setId(@NonNull String id) {
        Id = id;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public String getContra() {
        return Contra;
    }

    public void setContra(String contra) {
        Contra = contra;
    }

    public List<String> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(String favoritos) {
        this.favoritos.add(favoritos);
    }
}
