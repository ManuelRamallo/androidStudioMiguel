package com.mrdiaz.intentexplicito;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail, editTextContrasenya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextContrasenya = findViewById(R.id.editTextContrasenya);

    }

    public void doLogin(View view) {

        String email = editTextEmail.getText().toString();
        String contrasenya = editTextContrasenya.getText().toString();

        Log.i("Email", email);
        Log.i("Contraseña", contrasenya);


        if (email.equals("admin@admin.com") && contrasenya.equals("1234")){
            //El toast lo que hace es como un alert de javasscript, muestra por pantalla durante un breve periodo de tiempo el mensaje del "text"
            Toast.makeText(this, "Email: " + email + "  Password: " + contrasenya, Toast.LENGTH_SHORT).show();

            //Este componente Intent nos permite lanzar un nuevo activity en el primer plano de la aplicación
            //El activity actual se quedaría onPause.
            //Define desde donde voy hasta donde voy, desde MainActivity a DashboarActivity
            Intent intentDashboard = new Intent(MainActivity.this, DashboardActivity.class);

            //Esto lo que hace es enviar un valor desde el mainActivity a la siguiente página(siguiente activity)
            intentDashboard.putExtra("emailLogin", email);
            intentDashboard.putExtra("isLoggedIn", true);

            //Esto inicia el activity ejecutando el intent
            startActivity(intentDashboard);

            //Esto finaliza el activity para que cuando vuelvas atrás no aparezca (si es la primera pagina se cerraría la aplicacion)
            finish();

        } else {
            Toast.makeText(this, "Login Incorrecto", Toast.LENGTH_SHORT).show();
        }


    }
}
