package com.example.yanirayanes.gamenews;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityLoging extends AppCompatActivity {

    Button BotonSignIn;
    //NoticiasJuegosAPI NoticiasJuegosApi;
    String EnviarToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_loging);

        BotonSignIn = (Button) findViewById(R.id.BotonSignIn);

        //NoticiasJuegosApi = ApiUtiles.getNoticiasJuegosAPI();

        BotonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText EditTextUser = (EditText) findViewById(R.id.EditTextUser);
                final EditText EditTextPassword = (EditText) findViewById(R.id.EditTextPassword);

                String User = EditTextUser.getText().toString().trim();
                String Password = EditTextPassword.getText().toString().trim();

                if (!TextUtils.isEmpty(User) && !TextUtils.isEmpty(Password)) {
                    MandarToken(User, Password);
                }
            }
        });
    }

    public void MandarToken(final String User, final String Password){

    }

    private String guardarToken(Token token) {
        SharedPreferences preferencias = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEditor = preferencias.edit();
        prefEditor.putString("tokenpdm", token.getToken());
        prefEditor.commit();

        Log.i("PASE", "TOKEN: "+preferencias.getString("tokenpdm", "noToken"));

        return token.getToken();

    }
}
