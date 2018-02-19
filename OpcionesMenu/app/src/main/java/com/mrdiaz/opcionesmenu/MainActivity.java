package com.mrdiaz.opcionesmenu;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText email, asunto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_share:
                showDialogCompartir();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showDialogCompartir() {

        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.dialog_compartir_mensaje)
                .setTitle(R.string.dialog_compartir_mensaje_titulo);


        //Añadir layout personalizado
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_signin, null);
        builder.setView(dialogView);
        email = dialogView.findViewById(R.id.textInputEditEmail);
        asunto = dialogView.findViewById(R.id.textInputEditAsunto);




        //Añadir botones
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //Enviar email
                String[] emails = {email.getText().toString()};
                composeEmail(emails, asunto.getText().toString());
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });


        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();

        //4.Mostrar el dialogo en la pantalla
        dialog.show();

    }

    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, "Hola, te paso el contenido de ejemplo");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
