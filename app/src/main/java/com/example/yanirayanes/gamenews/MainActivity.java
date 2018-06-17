package com.example.yanirayanes.gamenews;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yanirayanes.gamenews.Adapter.RecyclerViewNoticias;
import com.example.yanirayanes.gamenews.BaseDeDatos.NoticiasDAO;
import com.example.yanirayanes.gamenews.PlainOldJavaObjects.Noticia;
import com.example.yanirayanes.gamenews.TodoLoDeLaAPI.ApiEndPoint;
import com.example.yanirayanes.gamenews.TodoLoDeLaAPI.NoticiasJuegosAPI;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView MiReVi;
    NoticiasJuegosAPI api;
    List<Noticia> noticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        api = ApiEndPoint.getGameNewsAPI();
        String HelloWorld = "Hello World Im Alive";
        Log.d("alv",HelloWorld.replaceAll("",""));
        String getToken = getIntent().getStringExtra("Token");
        CargarNoticias(getToken.replaceAll(" "," "));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        MiReVi = findViewById(R.id.Recyclerview);

        GridLayoutManager layoutManager = new GridLayoutManager(this,6);

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (position % 3){
                    case 0:
                        return 4;
                        //No se usa break; porque se esta retornando
                    case 1:
                    case 2:
                        return 2;
                }
                throw new IllegalStateException("Error interno");
            }
        });
        Log.d("MainActivitySegunda",getToken);
        MiReVi.setLayoutManager(layoutManager);
    }

    public void CargarNoticias(String Token){
        api.getNews(Token).enqueue(new Callback<List<Noticia>>() {
            @Override
            public void onResponse(Call<List<Noticia>> call, Response<List<Noticia>> response) {
                if(response.isSuccessful()) {
                    noticias = response.body();
                    //mResponseTv.setText(news[0].getTitle());
                    MiReVi.setAdapter(new RecyclerViewNoticias(noticias));


                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    Log.d("RESPONSE CODE: ", ""+statusCode);
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<List<Noticia>> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
                Log.d("Message ",t.toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
