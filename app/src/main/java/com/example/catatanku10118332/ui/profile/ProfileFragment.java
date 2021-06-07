package com.example.catatanku10118332.ui.profile;

//4 Juni 2021 - Nais Farid - IF8 - 10118332

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.catatanku10118332.R;

public class ProfileFragment extends Fragment {
    private CardView instagram,email;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        email = view.findViewById(R.id.cardEmail);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(Intent.ACTION_VIEW);
                e.setData(Uri.parse("mailto:achmad.zhaki21@gmail.com"));
                e.setType("text/plain");
                startActivity(e);
            }
        });

        instagram = view.findViewById(R.id.cardInstagram);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.instagram.com/faridnais8";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

}