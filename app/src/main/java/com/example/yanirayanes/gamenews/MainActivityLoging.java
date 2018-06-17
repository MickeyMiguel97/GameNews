package com.example.yanirayanes.gamenews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yanirayanes.gamenews.PlainOldJavaObjects.Token;
import com.example.yanirayanes.gamenews.TodoLoDeLaAPI.ApiEndPoint;
import com.example.yanirayanes.gamenews.TodoLoDeLaAPI.NoticiasJuegosAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityLoging extends AppCompatActivity {

    Button BotonSignIn;
    EditText EditTextPassword,EditTextUser;
    NoticiasJuegosAPI api;
    Token post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_loging);

        post = new Token();
        EditTextUser = findViewById(R.id.EditTextUser);
        EditTextPassword = findViewById(R.id.EditTextPassword);
        BotonSignIn = (Button) findViewById(R.id.BotonSignIn);

        api = ApiEndPoint.getGameNewsAPI();

        BotonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User = EditTextUser.getText().toString().trim();
                String Password = EditTextPassword.getText().toString().trim();
                if (!TextUtils.isEmpty(User) && !TextUtils.isEmpty(Password)) {
                    MandarToken(User, Password);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void MandarToken(final String User, final String Password){
        api.savePost(User,Password).enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if(response.isSuccessful()){
                    showResponse(response.body().toString());
                    if(response.body().toString() != null){
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(),"Usuario no registrado", Toast.LENGTH_SHORT).show();
                    }
                    Log.i("NoEntendíx3","El token se mando a la api"+ response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.e("NoEntendíx2","No se pudo mandar el token a la Api");
            }
        });
    }

    public void showResponse(String response) {
        Log.d("NoEntendi", "es null: "+(response==null));
    }
}
