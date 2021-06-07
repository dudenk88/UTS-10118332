package com.example.catatanku10118332.CRUD;

//5 Juni 2021 - Nais Farid - IF8 - 10118332

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.catatanku10118332.IView.IListView;
import com.example.catatanku10118332.R;

public class CreateDialog extends AppCompatDialogFragment {

    private EditText editTextName;
    private EditText editTextTime;
    private EditText editTextCatatan;

    private IListView iListView;




    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("Insert Notes")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Save ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String name = editTextName.getText().toString();
                        String time = editTextTime.getText().toString();
                        String catatan = editTextCatatan.getText().toString();
                        iListView.createStudent(name, time, catatan);
                    }
                });

        editTextName = view.findViewById(R.id.edit_name);
        editTextTime = view.findViewById(R.id.edit_time);
        editTextCatatan = view.findViewById(R.id.edit_catatan);

        return builder.create();
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            iListView = (IListView) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + "should implements Interface IView");
        }
    }


}
