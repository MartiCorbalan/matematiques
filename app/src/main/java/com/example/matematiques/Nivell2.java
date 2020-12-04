package com.example.matematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.text.DecimalFormat;


public class Nivell2 extends AppCompatActivity {

    Button corretgir;
    ImageView flecha;
    TextView NumeroMulti;
    TextView NumeroMulti2;

    TextView NumDiv;
    TextView NumDiv2;

    TextView NumeroMultiiDiv;
    TextView NumeroMultiiDiv2;
    TextView NumeroMultiiDiv3;

    EditText PosarMulti, PosarDiv, PosarMultiiDiv;

    int NumeroMultiGlobal = 0;
    int NumeroMultiGlobal2 = 0;

    int NumeroDivGlobal = 0;
    int NumeroDivGlobal2 = 0;

    int NumeroMultiiDivGlobal = 0;
    int NumeroMultiiDivGlobal2 = 0;
    int NumeroMultiiDivGlobal3 = 0;

    String Multi1;
    String Multi2;

    String Div1;
    String Div2;

    String MultiIDiv;
    String MultiIDiv2;
    String MultiIDiv3;

    LottieAnimationView Correcto;
    LottieAnimationView Incorrecto;
    LottieAnimationView Correcto1;
    LottieAnimationView Incorrecto1;
    LottieAnimationView Correcto2;
    LottieAnimationView Incorrecto2;

    int puntuacio=0;

    TextView puntuaciooooo;
    int puntuacioTotal;
    int contadorNivells;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivell2);



        puntuaciooooo=findViewById(R.id.puntuacioooo);
        flecha = findViewById(R.id.flecha);
        NumeroMulti = (TextView)findViewById(R.id.numeroMulti);
        NumeroMulti2 = (TextView)findViewById(R.id.numeroMulti2);

        NumDiv = (TextView)findViewById(R.id.numDiv);
        NumDiv2 = (TextView)findViewById(R.id.numDiv2);

        NumeroMultiiDiv = (TextView)findViewById(R.id.NumeroMultiiDiv);
        NumeroMultiiDiv2 = (TextView)findViewById(R.id.NumeroMultiiDiv2);
        NumeroMultiiDiv3 = (TextView)findViewById(R.id.NumeroMultiiDiv3);

        corretgir = (Button)findViewById(R.id.corretgir);

        PosarMulti = (EditText)findViewById(R.id.PosarMulti);
        PosarMultiiDiv = (EditText)findViewById(R.id.PosarMultiiDiv);
        PosarDiv = (EditText)findViewById(R.id.PosarDiv);

        Correcto=(LottieAnimationView)findViewById(R.id.correcto);
        Incorrecto=(LottieAnimationView)findViewById(R.id.incorrecto);
        Correcto1=(LottieAnimationView)findViewById(R.id.correcto1);
        Incorrecto1=(LottieAnimationView)findViewById(R.id.incorrecto1);
        Correcto2=(LottieAnimationView)findViewById(R.id.correcto2);
        Incorrecto2=(LottieAnimationView)findViewById(R.id.incorrecto2);

        Correcto.pauseAnimation();
        Incorrecto.pauseAnimation();
        Correcto.setVisibility(View.GONE);
        Incorrecto.setVisibility(View.GONE);
        Correcto1.pauseAnimation();
        Incorrecto1.pauseAnimation();
        Correcto1.setVisibility(View.GONE);
        Incorrecto1.setVisibility(View.GONE);
        Correcto2.pauseAnimation();
        Incorrecto2.pauseAnimation();
        Correcto2.setVisibility(View.GONE);
        Incorrecto2.setVisibility(View.GONE);


        mostrarinfo();


        corretgir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                corretgir();
            }
        });

        flecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent (v.getContext(), Nivell3.class);

                startActivityForResult(intent, 0);
            }
        });



    }


    public void corretgir(){

      puntuacio=0;


                int multiplicacio = NumeroMultiGlobal * NumeroMultiGlobal2;
                int multiIDiv = NumeroMultiiDivGlobal * NumeroMultiiDivGlobal2 / NumeroMultiiDivGlobal3;
                int divisio = NumeroDivGlobal / NumeroDivGlobal2;

                String resultat = String.valueOf(multiplicacio);
                String resultat2 = String.valueOf(multiIDiv);
                String resultat3 = String.valueOf(divisio);

                if (resultat.equals(PosarMulti.getText().toString())) {
                    Correcto.setVisibility(View.VISIBLE);
                    Correcto.playAnimation();
                    puntuacio++;
                } else {
                    Incorrecto.setVisibility(View.VISIBLE);
                    Incorrecto.playAnimation();
                }
                if (resultat3.equals(PosarDiv.getText().toString())) {
                    Correcto1.setVisibility(View.VISIBLE);
                    Correcto1.playAnimation();
                    puntuacio++;
                } else {
                    Incorrecto1.setVisibility(View.VISIBLE);
                    Incorrecto1.playAnimation();
                }
                if (resultat2.equals(PosarMultiiDiv.getText().toString())) {
                    Correcto2.setVisibility(View.VISIBLE);
                    Correcto2.playAnimation();
                    puntuacio++;
                } else {
                    Incorrecto2.setVisibility(View.VISIBLE);
                    Incorrecto2.playAnimation();
                }

                    puntuacioTotal += puntuacio;

                    contadorNivells++;
                    corretgir.setVisibility(View.GONE);
                    puntuaciooooo.setVisibility(View.VISIBLE);

                    puntuaciooooo.setText("Has conseguit aquests punts: " + puntuacio + " la teva puntuacio total es de: " + puntuacioTotal);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                desmarcar();
                mostrarinfo();


            }
        }, 4000);

        if (contadorNivells == 4){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent (Nivell2.this, Nivell3.class);


                    startActivityForResult(intent, 0);
                    finish();
                }
            },2000);


        }

    }

   public void mostrarinfo(){

       NumeroMultiGlobal = (int) (Math.random()*100) + 1;
       Multi1 = String.valueOf(NumeroMultiGlobal);
       NumeroMulti.setText(Multi1);


       NumeroMultiGlobal2 = (int) (Math.random()*100) + 1;
       Multi2 = String.valueOf(NumeroMultiGlobal2);
       NumeroMulti2.setText(Multi2);

       int min=1;
       int max=99;

       int contador=0;


       while (contador != 1){

           NumeroDivGlobal = (int) (Math.random()*max) + min;
           NumeroDivGlobal2 = (int) (Math.random()*20) + min;


           if (NumeroDivGlobal>=NumeroDivGlobal2 && NumeroDivGlobal % NumeroDivGlobal2 == 0){

               Div1 = String.valueOf(NumeroDivGlobal);
               NumDiv.setText(Div1);


               Div2 = String.valueOf(NumeroDivGlobal2);
               NumDiv2.setText(Div2);

               contador=1;
           }

       }
/*
       NumeroMultiiDivGlobal = (int) (Math.random()*10) + 1;
       MultiIDiv = String.valueOf(NumeroMultiiDivGlobal);
       NumeroMultiiDiv.setText(MultiIDiv);

       NumeroMultiiDivGlobal2 = (int) (Math.random()*10) + 1;
       MultiIDiv2 = String.valueOf(NumeroMultiiDivGlobal2);
       NumeroMultiiDiv2.setText(MultiIDiv2);

       NumeroMultiiDivGlobal3 = (int) (Math.random()*10) + 1;
       MultiIDiv3 = String.valueOf(NumeroMultiiDivGlobal3);
       NumeroMultiiDiv3.setText(MultiIDiv3);
*/

       int contadooor =0;

       while (contadooor != 1){

           NumeroMultiiDivGlobal = (int) (Math.random()*20) + 1;
           MultiIDiv = String.valueOf(NumeroMultiiDivGlobal);
           NumeroMultiiDiv.setText(MultiIDiv);

           NumeroMultiiDivGlobal2 = (int) (Math.random()*20) + 1;
           MultiIDiv2 = String.valueOf(NumeroMultiiDivGlobal2);
           NumeroMultiiDiv2.setText(MultiIDiv2);

           NumeroMultiiDivGlobal3 = (int) (Math.random()*20) + 1;
           MultiIDiv3 = String.valueOf(NumeroMultiiDivGlobal3);
           NumeroMultiiDiv3.setText(MultiIDiv3);
/*
           NumeroMultiiDivGlobal = (int) (Math.random()*20) + min;
           NumeroMultiiDivGlobal2 = (int) (Math.random()*20) + min;
           NumeroMultiiDivGlobal3 = (int) (Math.random()*20) + min;*/

       int divisible =  NumeroMultiiDivGlobal * NumeroMultiiDivGlobal2;

           if (divisible % NumeroMultiiDivGlobal3 == 0){

               MultiIDiv = String.valueOf(NumeroMultiiDivGlobal);
               NumeroMultiiDiv.setText(MultiIDiv);


               MultiIDiv2 = String.valueOf(NumeroMultiiDivGlobal2);
               NumeroMultiiDiv2.setText(MultiIDiv2);

               MultiIDiv3 = String.valueOf(NumeroMultiiDivGlobal3);
               NumeroMultiiDiv3.setText(MultiIDiv3);

               contadooor=1;
           }

       }

   }


    public void desmarcar(){

        corretgir.setVisibility(View.VISIBLE);
        puntuaciooooo.setVisibility(View.GONE);

        PosarMulti.getText().clear();
        PosarDiv.getText().clear();
        PosarMultiiDiv.getText().clear();

        Correcto.setVisibility(View.GONE);
        Incorrecto.setVisibility(View.GONE);

        Correcto1.setVisibility(View.GONE);
        Incorrecto1.setVisibility(View.GONE);

        Correcto2.setVisibility(View.GONE);
        Incorrecto2.setVisibility(View.GONE);

    }



}

