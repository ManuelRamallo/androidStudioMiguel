package com.miguelcr.a01_helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // La siguiente línea carga el fichero XML
        // que tiene la IU de esta pantalla (HomeScreen)
        setContentView(R.layout.activity_home_screen);
    }
}
