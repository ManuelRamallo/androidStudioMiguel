package com.mrdiaz.a07_restaurantlistfragment;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
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
        restaurantList.add(new Restaurant("Goiko Grill", "republica argentina", "", 5));
        restaurantList.add(new Restaurant("Cibeles", "Plaza Nueva", "", 0));
        restaurantList.add(new Restaurant("TGB", "republica argentina", "", 3));



        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyRestaurantRecyclerViewAdapter(restaurantList));
        }
        return view;
    }

}
