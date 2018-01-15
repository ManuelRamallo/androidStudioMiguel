package com.mrdiaz.intentexplicito;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Con Bundle rescata los extras (putExtra) del anterior Activity
        Bundle extras = getIntent().getExtras();

        //El key tiene que ser el mismo nombre que pusimos en el putExtra del anterior activity,
        // muy importante no cambiar el nombre del key
        //Así va en todos los extras que queramos rescatar, y así todas las variables
        //String email = extras.getString("emailLogin");

        //Con esto no da fallo porque es constante y no puede tener fallo, daría un aviso si te equivocas
        String email = extras.getString(Constantes.EXTRA_EMAIL);
        boolean estaLogueado = extras.getBoolean("isLoggedIn");

        TextView textViewEmail = findViewById(R.id.textViewEmail);
        textViewEmail.setText(email);

    }
}
