package com.miguelcr.a03_2intentexplicito;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPass = findViewById(R.id.editTextPassword);
    }


    public void doLogin(View view) {
        String email = editTextEmail.getText().toString();
        String pass = editTextPass.getText().toString();

        if(email.equals("admin@admin.com") && pass.equals("1234")) {
            // Este componente Intent nos permite lanzar un nuevo
            // Activity en el primer plano de la aplicación
            // El Activity actual se quedaría onPause.
            Intent intentDashboard = new Intent(this,DashboardActivity.class);
            intentDashboard.putExtra(Constantes.EXTRA_EMAIL, email);
            intentDashboard.putExtra("isLoggedIn", true);
            startActivity(intentDashboard);
        } else {
            Toast.makeText(
                    this,
                    "Login incorrecto, intente hackear otra app",
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
