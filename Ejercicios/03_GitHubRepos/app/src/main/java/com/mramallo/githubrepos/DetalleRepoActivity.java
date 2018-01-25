package com.mramallo.githubrepos;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleRepoActivity extends AppCompatActivity {

    TextView name;
    TextView fullName;
    ImageView imageView;


    /*Intento mostrar los datos al pasar a los detalles del activity, pero no se como hacerlo, lo unico
    * que consigo es mostrar la referencia del lugar donde se guarda el array de repositorios, es lo máximo
    * que he podido conseguir. Espero que se explique pronto para poder terminar el ejercicio completo*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_repo);

        name = findViewById(R.id.name);
        fullName = findViewById(R.id.full_name);
        imageView = findViewById(R.id.imageViewAvatar);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("name");
        String nombreCompleto = bundle.getString("fullName");

        name.setText(nombre);
        fullName.setText(nombreCompleto);


    }

}
