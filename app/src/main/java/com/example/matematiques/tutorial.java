package com.example.matematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;


public class tutorial extends AppCompatActivity {

    TextView NumeroSuma;
    TextView Numero2Suma;

    EditText PosarSuma;

    String Suma1;
    String Suma2;

    Button corretgir;

    int NumeroSumaGlobal = 0;
    int NumeroSuma2Global = 0;

    LottieAnimationView Correcto;
    LottieAnimationView Incorrecto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);



        NumeroSuma = (TextView)findViewById(R.id.NumeroSuma);
        Numero2Suma = (TextView)findViewById(R.id.Numero2Suma);

        corretgir = (Button)findViewById(R.id.corretgir);

        Correcto=(LottieAnimationView)findViewById(R.id.correcto);
        Incorrecto=(LottieAnimationView)findViewById(R.id.incorrecto);

        Correcto.pauseAnimation();
        Incorrecto.pauseAnimation();
        Correcto.setVisibility(View.GONE);
        Incorrecto.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mostrarinfo();

                corretgir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        corretgir();
                    }
                });
            }
        }, 2000);
    }


    public void corretgir(){

        int suma = NumeroSumaGlobal + NumeroSuma2Global;
        String resultat = String.valueOf(suma);

        if (resultat.equals(PosarSuma.getText().toString())) {
            Correcto.setVisibility(View.VISIBLE);
            Correcto.playAnimation();

        } else {
            Incorrecto.setVisibility(View.VISIBLE);
            Incorrecto.playAnimation();
        }
    }

    public void mostrarinfo(){

        NumeroSumaGlobal = (int) (Math.random()*20) + 1;
        Suma1 = String.valueOf(NumeroSumaGlobal);
        NumeroSuma.setText(Suma1);


        NumeroSuma2Global = (int) (Math.random()*20) + 1;
        Suma2 = String.valueOf(NumeroSuma2Global);
        Numero2Suma.setText(Suma2);

    }
    public void desmarcar(){

       /* corretgir.setVisibility(View.VISIBLE);
        puntuaciooooo.setVisibility(View.GONE);*/

        PosarSuma.getText().clear();
        /*PosarResta.getText().clear();
        PosarSumairesta.getText().clear();*/

        Correcto.setVisibility(View.GONE);
        Incorrecto.setVisibility(View.GONE);

        /*Correcto1.setVisibility(View.GONE);
        Incorrecto1.setVisibility(View.GONE);

        Correcto2.setVisibility(View.GONE);
        Incorrecto2.setVisibility(View.GONE);*/

    }
}