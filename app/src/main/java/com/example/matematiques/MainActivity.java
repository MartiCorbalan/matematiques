package com.example.matematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String userMain;
    Boolean registrat = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonComençar = (Button) findViewById(R.id.buttonComençar);
        Button btnRanking = (Button) findViewById(R.id.btnRanking);




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



    }
}