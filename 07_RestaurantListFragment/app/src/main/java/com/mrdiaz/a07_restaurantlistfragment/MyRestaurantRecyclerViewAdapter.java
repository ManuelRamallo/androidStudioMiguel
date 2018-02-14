package com.mrdiaz.a07_restaurantlistfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;



public class MyRestaurantRecyclerViewAdapter extends RecyclerView.Adapter<MyRestaurantRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<Restaurant> mValues;

    public MyRestaurantRecyclerViewAdapter(Context context, List<Restaurant> items) {
        ctx = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.textViewNombre.setText(holder.mItem.getNombre());
        holder.textViewDireccion.setText(holder.mItem.getDireccion());
        holder.ratingBarRate.setRating(holder.mItem.getRate());

        //Seteamos la imagen en el componente ImageView
        Picasso.with(ctx)
                .load(holder.mItem.getFoto())
                .into(holder.imageViewIcono);


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewNombre;
        public final TextView textViewDireccion;
        public final ImageView imageViewIcono;
        public final RatingBar ratingBarRate;
        public Restaurant mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewDireccion = view.findViewById(R.id.textViewDireccion);
            textViewNombre = view.findViewById(R.id.textViewNombre);
            imageViewIcono = view.findViewById(R.id.imageViewIcono);
            ratingBarRate = view.findViewById(R.id.ratingBarRate);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewNombre.getText() + "'";
        }
    }
}
