package com.example.matematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class nivells extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivells);

       TextView btnNivell1 =  findViewById(R.id.btnlvl1);
        TextView btnNivell2 =  findViewById(R.id.btnlvl2);
        TextView btnNivell3 =  findViewById(R.id.btnlvl3);
        TextView btnTornar =  findViewById(R.id.tornarInici);
        TextView usuari = (TextView) findViewById(R.id.mostrarUser);


        Bundle bundle = getIntent().getExtras();
        if(bundle !=null)
        {
            String userMain = bundle.getString("usuaris");
            usuari.setText(userMain);
        }

        btnNivell1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent (v.getContext(), Nivell1.class);

                startActivityForResult(intent, 0);
            }
        });
        btnNivell2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Nivell2.class);
                startActivityForResult(intent, 0);
            }
        });
        btnNivell3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Nivell3.class);
                startActivityForResult(intent, 0);
            }
        });

        btnTornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });





    }

}