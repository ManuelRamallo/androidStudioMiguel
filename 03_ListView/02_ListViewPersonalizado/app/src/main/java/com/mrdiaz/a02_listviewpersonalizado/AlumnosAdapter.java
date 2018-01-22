package com.mrdiaz.a02_listviewpersonalizado;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mrdiaz on 22/01/2018.
 */

class AlumnosAdapter extends ArrayAdapter<Alumno>{

    Context ctx;
    int template;
    List<Alumno> listaElementos;

    public AlumnosAdapter(@NonNull Context context, int resource, @NonNull List<Alumno> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.template = resource;
        this.listaElementos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //En el objeto "V" (por ejemplo el constraint layout) tenemos una referencia al root element del "template"
        //El template es el layout que hemos pasado en el adapter de mainactivity, el int es porque es el número de referencia que tiene

        //false para que este siempre por debajo del padre, si estuviese en true
        //sería hermano y no nos vale...
        View v = LayoutInflater.from(ctx).inflate(template, parent, false);

        //1. Rescatar los elementos visuales de mi layout
        ImageView ivFoto = v.findViewById(R.id.imageViewFoto);
        TextView tvNombre = v.findViewById(R.id.textViewNombre);
        TextView tvEdad = v.findViewById(R.id.textViewEdad);
        TextView tvMedia = v.findViewById(R.id.textViewNotaMedia);

        //2. Rescatar los datos del alumno que estoy dibujando en este momento
        Alumno actual = listaElementos.get(position);
        String nombre = actual.getNombre();
        int edad = actual.getEdad();
        float media = actual.getMedia();
        String urlFoto = actual.getUrlFoto();

        //3. Setear los datos del alumno en los View Components
        tvNombre.setText(nombre);
        tvEdad.setText(edad + " años");
        tvMedia.setText(String.valueOf(media)); //Esto es por que es un float
        Picasso.with(ctx).load(urlFoto).into(ivFoto);


        return v;
    }
}
