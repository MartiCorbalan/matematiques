package com.example.matematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ranking extends AppCompatActivity {

    ArrayList<jugador> copiaJugador = new ArrayList<>(login.arrayJugador);
    TextView jugador1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        jugador1 = findViewById(R.id.j1);

        ordenarJugadors();

        jugador1.setText(copiaJugador.get(0).getNom());








    }


    public void ordenarJugadors(){

        Collections.sort(copiaJugador, new Comparator<jugador>() {
            @Override
            public int compare(jugador o1, jugador o2) {
                return new Integer(o2.puntuacio).compareTo(new Integer(o1.puntuacio));
            }
        });

    }

}