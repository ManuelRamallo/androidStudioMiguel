package com.mramallo.appgooglekeep;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    TextView recordar, contraseña;
    TextInputEditText email;
    Button iniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        recordar = findViewById(R.id.textViewRecordar);
        iniciarSesion = findViewById(R.id.buttonIniciarSesion);

        eventListener();

    }

    private void eventListener(){
        recordar.setOnClickListener(this);
        iniciarSesion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int seleccion = v.getId();

        switch (seleccion){
            case R.id.textViewRecordar:
                showDialogRecordar();
                break;

            case R.id.buttonIniciarSesion:
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                break;
        }


    }


    private void showDialogRecordar() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.dialog_recordar_contrasenya_title).setMessage(R.string.dialog_recordar_contrasenya);

        View dialogView = getLayoutInflater().inflate(R.layout.dialog_contrasenya, null);
        builder.setView(dialogView);

        email = dialogView.findViewById(R.id.dialog_email);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String[] emails = {email.getText().toString()};
                composeEmail(emails);
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();

        dialog.show();


    }

    public void composeEmail(String[] addresses) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
