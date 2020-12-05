package com.example.matematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class carga extends AppCompatActivity {

    LottieAnimationView avio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);


        avio=(LottieAnimationView)findViewById(R.id.carga);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent = new Intent (carga.this, Nivell1.class);

                startActivityForResult(intent, 0);




            }
        }, 4000);

    }
}