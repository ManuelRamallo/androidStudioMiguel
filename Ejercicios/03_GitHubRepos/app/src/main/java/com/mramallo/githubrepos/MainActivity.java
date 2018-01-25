package com.mramallo.githubrepos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Repo> repositorios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listaRepos);

        Bundle extra = getIntent().getExtras();

        String nombreUsuario = extra.getString("nombreUsuario");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        Call<List<Repo>> repos = service.listRepos(nombreUsuario);

        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                repositorios = response.body();

                RepositoriosAdapter adaptadorRepo = new RepositoriosAdapter(
                        MainActivity.this,
                        R.layout.list_repos_item,
                        repositorios
                );

                listView.setAdapter(adaptadorRepo);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(view.getContext(), DetalleRepoActivity.class);
                        i.putExtra("name", String.valueOf(repositorios.get(position)));
                        i.putExtra("fullName", String.valueOf(repositorios.get(position)));
                        startActivity(i);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });

    }
}
