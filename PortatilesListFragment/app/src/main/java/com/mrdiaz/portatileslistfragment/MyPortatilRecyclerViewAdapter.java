package com.mrdiaz.portatileslistfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class MyPortatilRecyclerViewAdapter extends RecyclerView.Adapter<MyPortatilRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private IOnPortatilInteractionListener mListener;
    private final List<Portatil> mValues;

    public MyPortatilRecyclerViewAdapter(Context context, List<Portatil> items, IOnPortatilInteractionListener listener) {
        mValues = items;
        ctx = context;
        mListener = listener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_portatil, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.textViewModelo.setText(holder.mItem.getModelo());
        holder.textViewMarca.setText(holder.mItem.getMarca());
        holder.textViewPrecio.setText(holder.mItem.getPrecio() + " €");

        Picasso.with(ctx).load(holder.mItem.getFoto()).into(holder.imageViewFoto);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onPortatilClick(holder.mItem);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public Portatil mItem;
        public final TextView textViewModelo;
        public final TextView textViewMarca;
        public final ImageView imageViewFoto;
        public final TextView textViewPrecio;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewModelo = view.findViewById(R.id.textViewMarca);
            textViewMarca = view.findViewById(R.id.textViewModelo);
            textViewPrecio = view.findViewById(R.id.textViewPrecio);
            imageViewFoto = view.findViewById(R.id.imageViewFoto);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewModelo.getText() + "'";
        }
    }
}
