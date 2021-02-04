package com.example.anyseat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class BoardFragment extends Fragment {

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_board, container, false);


        button1 = view.findViewById(R.id.board1);
        button2 = view.findViewById(R.id.board2);
        button3 = view.findViewById(R.id.board3);
        button4 = view.findViewById(R.id.board4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), FreeBoardActivity.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}