package com.mramallo.githubrepos;

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
 * Created by ridex on 23/01/2018.
 */

public class RepositoriosAdapter extends ArrayAdapter<Repo> {

    Context ctx;
    List<Repo> listaRepos;
    int template;

    public RepositoriosAdapter(@NonNull Context context, int resource, @NonNull List<Repo> objects) {
        super(context, resource, objects);
        ctx = context;
        listaRepos = objects;
        template = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = LayoutInflater.from(ctx).inflate(template, parent, false);

        ImageView ivFoto = v.findViewById(R.id.imageViewAvatar);
        TextView tvNombre = v.findViewById(R.id.textViewNombreRepo);

        Repo actual = listaRepos.get(position);
        String nombre = actual.getName();
        String urlFotoAvatar = actual.getOwner().getAvatarUrl();

        tvNombre.setText(nombre);
        Picasso.with(ctx).load(urlFotoAvatar).into(ivFoto);

        return v;
    }
}
