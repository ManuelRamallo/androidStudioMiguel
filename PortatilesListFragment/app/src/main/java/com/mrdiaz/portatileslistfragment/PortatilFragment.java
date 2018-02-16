package com.mrdiaz.portatileslistfragment;

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

public class PortatilFragment extends Fragment {


    private int mColumnCount = 1;
    List<Portatil> portatilesList;
    MyPortatilRecyclerViewAdapter adapter;
    IOnPortatilInteractionListener mListener;


    public PortatilFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_portatil_list, container, false);

        portatilesList =   new ArrayList<>();
        portatilesList.add(new Portatil("MSI GL62M", "MSI", 999, "https://thumb.pccomponentes.com/w-530-530/articles/13/136950/1369500.jpg"));
        portatilesList.add(new Portatil("MACBOOK AIR", "APPLE", 999, "https://thumb.pccomponentes.com/w-530-530/articles/13/132884/96327-gimp.jpg"));
        portatilesList.add(new Portatil("OMEN 15-CE016NS", "HP", 1199, "https://thumb.pccomponentes.com/w-530-530/articles/13/134728/1347280.jpg"));



        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            adapter = new MyPortatilRecyclerViewAdapter(getActivity(), portatilesList, mListener);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        //Con la siguiente condicion me aseguro que el MainActivity esté implementando la interfaz IOnPortatilInteractionListener
        //o lo que es lo mismo, que el MainActivity esté sobreescribiendo los métodos de la interfaz, en este caso el metodo
        //onPortatilClick
        //De esta manera me aseguro que desde el Adapter cuando el usuario haga Click en un elemento de la lista voy a poder
        //invccar al método OnPortatilClick del MainActivity
        if(context instanceof IOnPortatilInteractionListener){
            mListener = (IOnPortatilInteractionListener) context;
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
