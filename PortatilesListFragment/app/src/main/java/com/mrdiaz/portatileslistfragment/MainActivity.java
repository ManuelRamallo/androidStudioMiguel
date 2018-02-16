package com.mrdiaz.portatileslistfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IOnPortatilInteractionListener {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment f = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    f = new HomeFragment();
                    return true;
                case R.id.navigation_dashboard:
                    f = new DashboardFragment();
                    return true;
                case R.id.navigation_notifications:
                    f = new NotificationFragment();
                    return true;
            }


            if(f!=null){
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.contenedor, new PortatilFragment()).commit();
            }

            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Fragment por defecto
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, new PortatilFragment()).commit();
    }

    @Override
    public void onPortatilClick(Portatil portatil) {

        Intent i = new Intent(this, DetallesPortatilActivity.class);
        i.putExtra("nombre", portatil.getModelo());
        startActivity(i);

    }
}
