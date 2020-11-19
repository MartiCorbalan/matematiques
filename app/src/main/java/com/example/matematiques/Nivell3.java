package com.example.matematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import org.w3c.dom.Text;

public class Nivell3 extends AppCompatActivity {

    TextView enunciat1;
    TextView enunciat2;

    EditText resposta1;
    EditText resposta2;

    int numero1;
    int numero2;

    int numero3;
    int numero4;
    int numero5;

    Button corretgir;

    String suma1;



    LottieAnimationView Correcto;
    LottieAnimationView Incorrecto;
    LottieAnimationView Correcto1;
    LottieAnimationView Incorrecto1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivell3);

        enunciat1 = (TextView) findViewById(R.id.enunciat1);
        enunciat2 = (TextView) findViewById(R.id.enunciat2);

        resposta1 = (EditText) findViewById(R.id.resposta1);
        resposta2 = (EditText) findViewById(R.id.resposta2);

        corretgir = (Button) findViewById(R.id.btncorretgir);

        Correcto=(LottieAnimationView)findViewById(R.id.correcto);
        Incorrecto=(LottieAnimationView)findViewById(R.id.incorrecto);
        Correcto1=(LottieAnimationView)findViewById(R.id.correcto1);
        Incorrecto1=(LottieAnimationView)findViewById(R.id.incorrecto1);

        numero1 = (int) (Math.random()*100) + 1;
        numero2 = (int) (Math.random()*100) + 1;

        enunciat1.setText("Anna té una col·lecció de " + numero1 +  " cromos\n" +
                "de motos i Xavier té una col·lecció\n" +
                "de " + numero2 + " cromos d’animals.\n" +
                "Quants cromos tenen en total?");




        numero3 = (int) (Math.random()*100) + 1;
        numero4 = (int) (Math.random()*100) + 1;
        numero5 = (int) (Math.random()*100) + 1;


        enunciat2.setText("La tia d’Empar té un àlbum amb " + numero3 + " fotos. La setmana\n" +
                "passada hi va col·locar " + numero4 + "més i hi ha col·locat\n"+
                 numero5 + " fotos més. Quantes fotos té en l’àlbum?");

        corretgir();
    }


    public void corretgir(){
        corretgir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int suma = numero1 + numero2;
                int suma2 = numero3 + numero4 + numero5;

                String resultat = String.valueOf(suma);
                String resultat1 = String.valueOf(suma2);

                if(resultat.equals(resposta1.getText().toString())) {
                    Correcto.setVisibility(View.VISIBLE);
                    Correcto.playAnimation();
                } else {
                    Incorrecto.setVisibility(View.VISIBLE);
                    Incorrecto.playAnimation();
                }
                if(resultat1.equals(resposta2.getText().toString())){
                    Correcto1.setVisibility(View.VISIBLE);
                    Correcto1.playAnimation();
                }else{
                    Incorrecto1.setVisibility(View.VISIBLE);
                    Incorrecto1.playAnimation();
                }

            }
        });
    }

}