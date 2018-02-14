package com.mrdiaz.a07_restaurantlistfragment;

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

public class RestaurantFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;
    List<Restaurant> restaurantList;
    MyRestaurantRecyclerViewAdapter adapter;

    public RestaurantFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_list, container, false);

        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant("Goiko Grill", "republica argentina", "http://s03.s3c.es/imag/_v0/770x420/1/0/3/goiko-grill-coqueta.jpg", 5));
        restaurantList.add(new Restaurant("Cibeles", "Plaza Nueva", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjmFiemTWWgGu7VB84aK677DN1SgDkEyR49tk-QCEYD07NSmTL", 0));
        restaurantList.add(new Restaurant("TGB", "republica argentina", "https://media-cdn.tripadvisor.com/media/photo-s/0e/f0/91/92/tgb.jpg", 3));



        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            adapter = new MyRestaurantRecyclerViewAdapter(getActivity(), restaurantList);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

}
