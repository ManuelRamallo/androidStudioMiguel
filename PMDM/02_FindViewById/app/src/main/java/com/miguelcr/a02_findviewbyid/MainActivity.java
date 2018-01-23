package com.miguelcr.a02_findviewbyid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1. Se carga la IU
        setContentView(R.layout.activity_main);

        // 2. Rescatar elementos de la IU
        tvSaludo = findViewById(R.id.textViewSaludo);

        // 3. Modificar el elemento que he rescatado
        Log.i("IU","Texto antes de modificar: "+tvSaludo.getText());
        tvSaludo.setText("Bye bye World!");

        Log.i("CicloDeVida","Entra en onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("CicloDeVida","Entra en onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("CicloDeVida","Entra en onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("CicloDeVida","Entra en onPause()");
    }
}
