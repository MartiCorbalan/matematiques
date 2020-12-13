package com.example.matematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String userMain;
    Boolean registrat = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView buttonComençar =  findViewById(R.id.buttonComençar);
        TextView btnRanking =  findViewById(R.id.btnRanking);
        TextView tuto = findViewById(R.id.tutorial);



        Bundle bundle = getIntent().getExtras();
        if(bundle !=null)
        {
            userMain = bundle.getString("usuaris");

        }






        buttonComençar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, nivells.class);
                Bundle b = new Bundle();
                b.putString ("usuaris",userMain);
                intent.putExtras(b);
                startActivity(intent);


            }
        });

        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), ranking.class);
                startActivityForResult(intent, 0);

            }
        });

       tuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), tutorial.class);
                startActivityForResult(intent, 0);

            }
        });




    }
}