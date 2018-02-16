package com.mrdiaz.skyscanner2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

public class VuelosFragment extends Fragment {

    private int mColumnCount = 1;
    List<Vuelos> vuelosList;
    MyVuelosRecyclerViewAdapter adapter;
    private IOnVuelosIterationListener mListener;

    public VuelosFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vuelos_list, container, false);

        vuelosList = new ArrayList<>();

        vuelosList.add(new Vuelos("Iberia", "Sevilla", "Madrid", 120, "http://www.brandemia.org/wp-content/uploads/2013/10/logo_iberia_positivo.jpg"));
        vuelosList.add(new Vuelos("Ryanair", "Madrid", "Sevilla", 100, "http://4.bp.blogspot.com/-z-ieUWYhbiQ/TV5OyvzrvqI/AAAAAAAAAZ0/x4BTNxOIvBc/s1600/ryanair_identitat.jpg"));
        vuelosList.add(new Vuelos("Iberia", "Barcelona", "Madrid", 70, "http://www.brandemia.org/wp-content/uploads/2013/10/logo_iberia_positivo.jpg"));
        vuelosList.add(new Vuelos("Vueling", "Sevilla", "Barcelona", 150, "http://www.brandemia.org/wp-content/uploads/2013/10/logo_iberia_positivo.jpg"));

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            adapter = new MyVuelosRecyclerViewAdapter(getActivity(),vuelosList, mListener);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IOnVuelosIterationListener) {
            mListener = (IOnVuelosIterationListener) context;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
