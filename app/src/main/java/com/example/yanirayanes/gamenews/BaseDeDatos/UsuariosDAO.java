package com.example.yanirayanes.gamenews.BaseDeDatos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.yanirayanes.gamenews.PlainOldJavaObjects.Usuario;

import java.util.List;

@Dao
public interface UsuariosDAO {
    @Insert
    void insertUser(Usuario user);
    @Update
    void modifyUser(Usuario... users);
    @Query("SELECT * FROM usuarios WHERE user = :username")
    Usuario getUser(String username);
    @Query("SELECT * FROM usuarios")
    LiveData<List<Usuario>> getAllUsers();
}
