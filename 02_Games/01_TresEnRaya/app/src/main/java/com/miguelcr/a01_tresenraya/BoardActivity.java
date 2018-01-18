package com.miguelcr.a01_tresenraya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BoardActivity extends AppCompatActivity {

    TextView player1, player2, playerPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        playerPlay = findViewById(R.id.playerPlay);

        // Rescatar los nombres de los jugadores
        Bundle extras = getIntent().getExtras();

        String p1Name = extras.getString(Constantes.EXTRA_PLAYER_1);
        String p2Name = extras.getString(Constantes.EXTRA_PLAYER_2);

        player1.setText(p1Name);
        player2.setText(p2Name);
        playerPlay.setText(p1Name + " plays!");

    }
}
