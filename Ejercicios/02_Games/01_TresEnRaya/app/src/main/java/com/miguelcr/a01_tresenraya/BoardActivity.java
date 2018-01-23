package com.miguelcr.a01_tresenraya;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BoardActivity extends AppCompatActivity implements View.OnClickListener {

    TextView player1, player2, playerPlay;
    ImageView iv0, iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8;
    boolean isPlaying1 = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        iv0 = findViewById(R.id.imageView);
        iv1 = findViewById(R.id.imageView2);
        iv2 = findViewById(R.id.imageView5);
        iv3 = findViewById(R.id.imageView6);
        iv4 = findViewById(R.id.imageView7);
        iv5 = findViewById(R.id.imageView8);
        iv6 = findViewById(R.id.imageView9);
        iv7 = findViewById(R.id.imageView10);
        iv8 = findViewById(R.id.imageView11);
        playerPlay = findViewById(R.id.playerPlay);

        // Rescatar los nombres de los jugadores
        Bundle extras = getIntent().getExtras();

        String p1Name = extras.getString(Constantes.EXTRA_PLAYER_1);
        String p2Name = extras.getString(Constantes.EXTRA_PLAYER_2);

        //String idiomaUsuario = getString(R.string.idioma);
        player1.setText(p1Name);
        player2.setText(p2Name);
        playerPlay.setText(p2Name + " plays!");

        eventListeners();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.nuevaPartida:
                nuevaPartida();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void nuevaPartida() {
        Toast.makeText(this, "Va a empezar una nueva partida", Toast.LENGTH_SHORT).show();
    }


    private void eventListeners() {
        iv0.setOnClickListener(this);
        iv1.setOnClickListener(this);
        iv2.setOnClickListener(this);
        iv3.setOnClickListener(this);
        iv4.setOnClickListener(this);
        iv5.setOnClickListener(this);
        iv6.setOnClickListener(this);
        iv7.setOnClickListener(this);
        iv8.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int idCasilla = v.getId();
        ImageView casillaSeleccionada = null;


        switch (idCasilla) {
            case R.id.imageView:
                casillaSeleccionada = iv0;
                break;
            case R.id.imageView2:
                casillaSeleccionada = iv1;
                break;
            case R.id.imageView5:
                casillaSeleccionada = iv2;
                break;
            case R.id.imageView6:
                casillaSeleccionada = iv3;
                break;
            case R.id.imageView7:
                casillaSeleccionada = iv4;
                break;
            case R.id.imageView8:
                casillaSeleccionada = iv5;
                break;
            case R.id.imageView9:
                casillaSeleccionada = iv6;
                break;
            case R.id.imageView10:
                casillaSeleccionada = iv7;
                break;
            case R.id.imageView11:
                casillaSeleccionada = iv8;
                break;
        }


        if (isPlaying1) {
            casillaSeleccionada.setImageResource(R.drawable.ic_github_sign);
        } else {
            casillaSeleccionada.setImageResource(R.drawable.ic_bitbucket_sign);

        }

        isPlaying1 = !isPlaying1;

    }
}
