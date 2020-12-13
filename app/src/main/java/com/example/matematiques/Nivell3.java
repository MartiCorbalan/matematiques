package com.example.matematiques;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.service.notification.NotificationListenerService;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

public class Nivell3 extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String email = user.getEmail();
    private String id = "";

    Button corretgir;
    TextView enunciat1;
    TextView enunciat2;

    EditText resposta1;
    EditText resposta2;

    int numero1;
    int numero2;

    int numero3;
    int numero4;
    int numero5;



    LottieAnimationView Correcto;
    LottieAnimationView Incorrecto;
    LottieAnimationView Correcto1;
    LottieAnimationView Incorrecto1;
    LottieAnimationView avio;
    int puntuacio=0;

    TextView puntuacioo;
    int puntuacioTotal;
    int contadorNivells;
    int dbpuntuacioTotal;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivell3);

        buscarpuntuacio();

        puntuacioo=findViewById(R.id.puntuacio);

        enunciat1 = (TextView) findViewById(R.id.enunciat1);
        enunciat2 = (TextView) findViewById(R.id.enunciat2);

        resposta1 = (EditText) findViewById(R.id.resposta1);
        resposta2 = (EditText) findViewById(R.id.resposta2);

        corretgir = (Button) findViewById(R.id.btncorretgir);

        Correcto=(LottieAnimationView)findViewById(R.id.correcto);
        Incorrecto=(LottieAnimationView)findViewById(R.id.incorrecto);
        Correcto1=(LottieAnimationView)findViewById(R.id.correcto1);
        Incorrecto1=(LottieAnimationView)findViewById(R.id.incorrecto1);

        avio=(LottieAnimationView)findViewById(R.id.carga);

        Correcto.pauseAnimation();
        Incorrecto.pauseAnimation();
        Correcto.setVisibility(View.GONE);
        Incorrecto.setVisibility(View.GONE);
        Correcto1.pauseAnimation();
        Incorrecto1.pauseAnimation();
        Correcto1.setVisibility(View.GONE);
        Incorrecto1.setVisibility(View.GONE);

        avio.setVisibility(View.VISIBLE);
        corretgir.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                mostrarInfo();

                avio.setVisibility(View.GONE);

                corretgir.setVisibility(View.VISIBLE);

                corretgir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        corretgir();
                    }
                });
            }
        }, 2000);

        corretgir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                corretgir();
            }
        });

    }


    public void corretgir(){

        puntuacio=0;

                int suma = numero1 + numero2;
                int suma2 = numero3 + numero4 - numero5;

                String resultat = String.valueOf(suma);
                String resultat1 = String.valueOf(suma2);

                if(resultat.equals(resposta1.getText().toString())) {
                    Correcto.setVisibility(View.VISIBLE);
                    Correcto.playAnimation();
                    puntuacio++;
                    actualitzarpuntuacio();
                } else {
                    Incorrecto.setVisibility(View.VISIBLE);
                    Incorrecto.playAnimation();
                }
                if(resultat1.equals(resposta2.getText().toString())){
                    Correcto1.setVisibility(View.VISIBLE);
                    Correcto1.playAnimation();
                    puntuacio++;
                    actualitzarpuntuacio();
                }else{
                    Incorrecto1.setVisibility(View.VISIBLE);
                    Incorrecto1.playAnimation();
                }

                puntuacioTotal += puntuacio;

                contadorNivells++;
                corretgir.setVisibility(View.GONE);
                puntuacioo.setVisibility(View.VISIBLE);

                puntuacioo.setText("Has conseguit aquests punts: " + puntuacio + " la teva puntuacio total es de: "+ (dbpuntuacioTotal + puntuacio));
                actualitzarpuntuacio();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                desmarcar();
                mostrarInfo();
            }
        }, 4000);

        if (contadorNivells==4){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent (Nivell3.this, ranking.class);

                    startActivityForResult(intent, 0);
                    finish();
                }
            }, 2000);
        }
    }

    public void mostrarInfo(){

        int max= 20;
        int min=1;

        numero1 = (int) (Math.random()*99) + 1;
        numero2 = (int) (Math.random()*99) + 1;

        enunciat1.setText("Anna té una col·lecció de " + numero1 +  " cromos\n" +
                "de motos i en Xavier té una col·lecció\n" +
                "de " + numero2 + " cromos d’animals.\n" +
                "Quants cromos tenen en total?");


        numero3 = (int) (Math.random()*99) + 1;
        numero4 = (int) (Math.random()*10) + 1;
        numero5 = (int) (Math.random()*max) + min;


        enunciat2.setText("La tia d’Empar té un àlbum amb " + numero3 + " fotos." +
                "La setmana passada hi va col·locar " + numero4 + " fotos més, \n"+
                "però n'ha perdut " + numero5 + " fotos més. Quantes fotos té en l’àlbum?");


    }


    public void desmarcar(){

        corretgir.setVisibility(View.VISIBLE);
        puntuacioo.setVisibility(View.GONE);

        resposta1.getText().clear();
        resposta2.getText().clear();

        Correcto.setVisibility(View.GONE);
        Incorrecto.setVisibility(View.GONE);

        Correcto1.setVisibility(View.GONE);
        Incorrecto1.setVisibility(View.GONE);

    }


    public void buscarpuntuacio() {

        db.collection("usuaris")
                .whereEqualTo("email", email)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData());
                                id = document.getId();
                                dbpuntuacioTotal = Integer.parseInt(document.getData().get("puntuacio").toString());

                            }
                        } else {
                            Log.d("TAG", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }


    public void actualitzarpuntuacio() {

        if (puntuacioTotal >= dbpuntuacioTotal) {

            db.collection("usuaris").document(id).update("puntuacio", puntuacioTotal + dbpuntuacioTotal);

        }


    }



}