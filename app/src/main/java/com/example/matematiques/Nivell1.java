package com.example.matematiques;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;


public class Nivell1 extends AppCompatActivity {
    Button corretgir;
    ImageView flecha;
    TextView NumeroSuma;
    TextView Numero2Suma;

    TextView NumeroResta;
    TextView Numero2Resta;

    TextView NumeroSumaiResta;
    TextView Numero2SumaiResta;
    TextView Numero3SumaiResta;

    EditText PosarSuma;
    EditText PosarResta;
    EditText PosarSumairesta;


    int NumeroSumaGlobal = 0;
    int NumeroSuma2Global = 0;

    int NumeroRestaGlobal = 0;
    int NumeroResta2Global = 0;

    int NumeroSumaiRestaGlobal = 0;
    int NumeroSumaiResta2Global = 0;
    int NumeroSumaiResta3Global = 0;

    String Suma1;
    String Suma2;

    String Resta1;
    String Resta2;

    String SumaiResta1;
    String SumaiResta2;
    String SumaiResta3;

    LottieAnimationView Correcto;
    LottieAnimationView Incorrecto;
    LottieAnimationView Correcto1;
    LottieAnimationView Incorrecto1;
    LottieAnimationView Correcto2;
    LottieAnimationView Incorrecto2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivell1);
        flecha = findViewById(R.id.flecha);
        NumeroSuma = (TextView)findViewById(R.id.numeroSuma);
        Numero2Suma = (TextView)findViewById(R.id.numeroSuma2);

        NumeroResta = (TextView)findViewById(R.id.numResta);
        Numero2Resta = (TextView)findViewById(R.id.numResta2);

        NumeroSumaiResta = (TextView)findViewById(R.id.numSum_Rest);
        Numero2SumaiResta = (TextView)findViewById(R.id.numSum_Rest2);
        Numero3SumaiResta = (TextView)findViewById(R.id.numSum_Rest3);

        corretgir = (Button)findViewById(R.id.corretgir);

        PosarSuma = (EditText)findViewById(R.id.PosarSuma);
        PosarSumairesta = (EditText)findViewById(R.id.PosarRestaiSuma);
        PosarResta = (EditText)findViewById(R.id.PosarResta);

        Correcto=(LottieAnimationView)findViewById(R.id.correcto);
        Incorrecto=(LottieAnimationView)findViewById(R.id.incorrecto);
        Correcto1=(LottieAnimationView)findViewById(R.id.correcto1);
        Incorrecto1=(LottieAnimationView)findViewById(R.id.incorrecto1);
        Correcto2=(LottieAnimationView)findViewById(R.id.correcto2);
        Incorrecto2=(LottieAnimationView)findViewById(R.id.incorrecto2);

        NumeroSumaGlobal = (int) (Math.random()*100) + 1;
        Suma1 = String.valueOf(NumeroSumaGlobal);
        NumeroSuma.setText(Suma1);


        NumeroSuma2Global = (int) (Math.random()*100) + 1;
        Suma2 = String.valueOf(NumeroSuma2Global);
        Numero2Suma.setText(Suma2);


        int min=1;
        int max=99;

        int contador=0;

        while (contador != 1){
            NumeroRestaGlobal = (int) (Math.random()*max) + min;
            NumeroResta2Global = (int) (Math.random()*max) + min;
            if (NumeroRestaGlobal>=NumeroResta2Global){

                Resta2 = String.valueOf(NumeroResta2Global);
                Numero2Resta.setText(Resta2);


                Resta1 = String.valueOf(NumeroRestaGlobal);
                NumeroResta.setText(Resta1);

                contador=1;
            }

        }




        /*
        if (NumeroRestaGlobal>NumeroResta2Global || NumeroRestaGlobal>=NumeroResta2Global){
            NumeroResta2Global = (int) (Math.random()*max) + min;
            Resta2 = String.valueOf(NumeroResta2Global);
            Numero2Resta.setText(Resta2);
        }*/




        NumeroSumaiRestaGlobal = (int) (Math.random()*100) + 1;
        SumaiResta1 = String.valueOf(NumeroSumaiRestaGlobal);
        NumeroSumaiResta.setText(SumaiResta1);


        NumeroSumaiResta2Global = (int) (Math.random()*100) + 1;
        SumaiResta2 = String.valueOf(NumeroSumaiResta2Global);
        Numero2SumaiResta.setText(SumaiResta2);


        NumeroSumaiResta3Global = (int) (Math.random()*100) + 1;
        SumaiResta3 = String.valueOf(NumeroSumaiResta3Global);
        Numero3SumaiResta.setText(SumaiResta3);

        corretgir();

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


        flecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Nivell2.class);
                startActivityForResult(intent, 0);
            }
        });
    }


    public void corretgir(){
        corretgir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int suma = NumeroSumaGlobal + NumeroSuma2Global;
                int sumaiResta = NumeroSumaiRestaGlobal + NumeroSumaiResta2Global - NumeroSumaiResta3Global;
                int resta = NumeroRestaGlobal - NumeroResta2Global;

                String resultat = String.valueOf(suma);
                String resultat2 = String.valueOf(sumaiResta);
                String resultat3 = String.valueOf(resta);



                if (resultat.equals(PosarSuma.getText().toString())) {
                    Correcto.setVisibility(View.VISIBLE);
                    Correcto.playAnimation();
                } else {
                    Incorrecto.setVisibility(View.VISIBLE);
                    Incorrecto.playAnimation();
                }

                if (resultat2.equals(PosarSumairesta.getText().toString())) {
                    Correcto1.setVisibility(View.VISIBLE);
                    Correcto1.playAnimation();
                } else {
                    Incorrecto1.setVisibility(View.VISIBLE);
                    Incorrecto1.playAnimation();
                }

                if (resultat3.equals(PosarResta.getText().toString())) {
                    Correcto2.setVisibility(View.VISIBLE);
                    Correcto2.playAnimation();
                } else {
                    Incorrecto2.setVisibility(View.VISIBLE);
                    Incorrecto2.playAnimation();
                }

            }
        });
    }


}

