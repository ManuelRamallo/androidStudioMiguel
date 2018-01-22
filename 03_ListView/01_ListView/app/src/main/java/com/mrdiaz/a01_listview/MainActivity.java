package com.mrdiaz.a01_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    List<String> alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewAlumno);

        alumnos = new ArrayList<>();
        alumnos.add("Miguel");
        alumnos.add("Cesar");
        alumnos.add("Javier");
        alumnos.add("Juanfran");
        alumnos.add("Tiscar");
        alumnos.add("Cristina");
        alumnos.add("Jesus");
        alumnos.add("Jorge");
        alumnos.add("Javier Rogerio");
        alumnos.add("Jaime");
        alumnos.add("Sosa");


        ArrayAdapter adaptadorAlumno = new ArrayAdapter<String>(
          this, android.R.layout.simple_expandable_list_item_1, alumnos);

        //Conectamos el adapter con el listview
        listView.setAdapter(adaptadorAlumno);

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String alumnoClicked = alumnos.get(position);
        Toast.makeText(this, "El alumno es: " + alumnoClicked, Toast.LENGTH_SHORT).show();
        //se puede hacer cualquier cosa, esto es solo un ejemplo, rota la palabra del list view
        view.animate().rotationXBy(360).setDuration(2000).start();
    }
}
