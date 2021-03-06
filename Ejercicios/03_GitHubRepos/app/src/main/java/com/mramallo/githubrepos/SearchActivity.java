package com.mramallo.githubrepos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombreUsuario;
    Button buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        nombreUsuario= findViewById(R.id.nombreUsuario);
        buscar = findViewById(R.id.buscar);

        buscar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String nombreUser = nombreUsuario.getText().toString();

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("nombreUsuario", nombreUser);
        startActivity(i);
    }
}
