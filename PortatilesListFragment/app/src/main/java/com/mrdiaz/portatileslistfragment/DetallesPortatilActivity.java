package com.mrdiaz.portatileslistfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetallesPortatilActivity extends AppCompatActivity {

    TextView textViewModelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_portatil);

        textViewModelo = findViewById(R.id.textViewMod);

        Bundle extras = getIntent().getExtras();
        String modelo = extras.getString("nombre");

        textViewModelo.setText(modelo);

    }
}
