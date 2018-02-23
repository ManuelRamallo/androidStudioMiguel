package com.mrdiaz.dialogfragment;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

/**
 * Created by mrdiaz on 23/02/2018.
 */

public class NuevoUsuarioDialogFragment extends DialogFragment {

    //TODO TERMINAR DE COPIAR DEL EJEMPLO DE MIGUEL


    public NuevoUsuarioDialogFragment() {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Nuevo usuario");
        alertDialogBuilder.setMessage("Introduce los datos del nueso usuario?");
        alertDialogBuilder.setPositiveButton("Guardar",  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // on success
            }
        });
        alertDialogBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               /* if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }*/
            }

        });

        return alertDialogBuilder.create();
    }


}
