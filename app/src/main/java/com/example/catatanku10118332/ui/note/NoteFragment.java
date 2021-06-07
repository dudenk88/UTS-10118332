package com.example.catatanku10118332.ui.note;

//4 Juni 2021 - Nais Farid - IF8 - 10118332

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.catatanku10118332.R;
import com.example.catatanku10118332.NoteActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class NoteFragment extends Fragment {

    Activity context;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        View root = inflater.inflate(R.layout.fragment_note, container, false);

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        Button btn = (Button) context.findViewById(R.id.btnNote);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NoteActivity.class);
                startActivity(intent);
            }
        });
    }
}