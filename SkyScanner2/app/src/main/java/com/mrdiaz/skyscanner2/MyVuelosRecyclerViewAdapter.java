package com.mrdiaz.skyscanner2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyVuelosRecyclerViewAdapter extends RecyclerView.Adapter<MyVuelosRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<Vuelos> mValues;
    private final IOnVuelosIterationListener mListener;

    public  MyVuelosRecyclerViewAdapter(Context context, List<Vuelos> items, IOnVuelosIterationListener listener) {
        mValues = items;
        mListener = listener;
        ctx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_vuelos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.textViewNombre.setText(holder.mItem.getNombreCompanya());
        holder.textViewLlegada.setText(holder.mItem.getLlegada());
        holder.textViewSalida.setText(holder.mItem.getSalida());
        holder.textViewPrecio.setText(holder.mItem.getPrecio() + " €");

        Picasso.with(ctx).load(holder.mItem.getFoto()).into(holder.imageViewLogo);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onVuelosClick(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewNombre;
        public final TextView textViewLlegada;
        public final TextView textViewSalida;
        public final TextView textViewPrecio;
        public final ImageView imageViewLogo;
        public Vuelos mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewNombre = view.findViewById(R.id.textViewNombre);
            textViewLlegada = view.findViewById(R.id.textViewLlegada);
            textViewSalida = view.findViewById(R.id.textViewSalida);
            textViewPrecio = view.findViewById(R.id.textViewPrecio);
            imageViewLogo = view.findViewById(R.id.imageViewLogo);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewNombre.getText() + "'";
        }
    }
}
