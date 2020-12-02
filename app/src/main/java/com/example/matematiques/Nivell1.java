package com.example.matematiques;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class Nivell1 extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String email = user.getEmail();
    private String id = "";

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

    int puntuacio;
    TextView puntuaciooooo;
    int puntuacioTotal;
    int contadoNivells;

    int dbpuntuacioTotal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivell1);


        buscarpuntuacio();


        flecha = findViewById(R.id.flecha);
        puntuaciooooo=findViewById(R.id.puntuacioooo);

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
                Intent intent = new Intent (v.getContext(), Nivell2.class);
                startActivityForResult(intent, 0);
            }
        });
    }


    public void corretgir() {

        puntuacio=0;

        int suma = NumeroSumaGlobal + NumeroSuma2Global;
        int sumaiResta = NumeroSumaiRestaGlobal + NumeroSumaiResta2Global - NumeroSumaiResta3Global;
        int resta = NumeroRestaGlobal - NumeroResta2Global;

        String resultat = String.valueOf(suma);
        String resultat2 = String.valueOf(sumaiResta);
        String resultat3 = String.valueOf(resta);


        if (resultat.equals(PosarSuma.getText().toString())) {
            Correcto.setVisibility(View.VISIBLE);
            Correcto.playAnimation();
            puntuacio++;
        } else {
            Incorrecto.setVisibility(View.VISIBLE);
            Incorrecto.playAnimation();
        }

        if (resultat2.equals(PosarSumairesta.getText().toString())) {
            Correcto1.setVisibility(View.VISIBLE);
            Correcto1.playAnimation();
            puntuacio++;
        } else {
            Incorrecto1.setVisibility(View.VISIBLE);
            Incorrecto1.playAnimation();
        }

        if (resultat3.equals(PosarResta.getText().toString())) {
            Correcto2.setVisibility(View.VISIBLE);
            Correcto2.playAnimation();
            puntuacio++;
        } else {
            Incorrecto2.setVisibility(View.VISIBLE);
            Incorrecto2.playAnimation();
        }

        puntuacioTotal += puntuacio;

        //corretgir.setVisibility(View.GONE);
        //puntuaciooooo.setText("Has conseguit aquests punts: " + puntuacio);


        System.out.println(" id " + id);
                    contadoNivells++;
                    corretgir.setVisibility(View.GONE);
                    puntuaciooooo.setVisibility(View.VISIBLE);
                    puntuaciooooo.setText("Has conseguit aquests punts: " + puntuacio + " la teva puntuacio total es de: "+ puntuacioTotal);
                    actualitzarpuntuacio();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {




                            desmarcar();
                            mostrarinfo();



                        }
                    }, 4000);

        if (contadoNivells == 4){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent (Nivell1.this, Nivell2.class);

                    startActivityForResult(intent, 0);
                    finish();
                }
            },2000);


        }


    }


            public void mostrarinfo(){

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

                NumeroSumaiRestaGlobal = (int) (Math.random()*100) + 1;
                SumaiResta1 = String.valueOf(NumeroSumaiRestaGlobal);
                NumeroSumaiResta.setText(SumaiResta1);


                NumeroSumaiResta2Global = (int) (Math.random()*100) + 1;
                SumaiResta2 = String.valueOf(NumeroSumaiResta2Global);
                Numero2SumaiResta.setText(SumaiResta2);


                NumeroSumaiResta3Global = (int) (Math.random()*100) + 1;
                SumaiResta3 = String.valueOf(NumeroSumaiResta3Global);
                Numero3SumaiResta.setText(SumaiResta3);

                int contadoooooor=0;

                while (contadoooooor !=1){
                    int resultado =  NumeroSumaiRestaGlobal + NumeroSumaiResta2Global;
                    if (NumeroSumaiResta3Global > resultado){

                        NumeroSumaiRestaGlobal = (int) (Math.random()*100) + 1;
                        SumaiResta1 = String.valueOf(NumeroSumaiRestaGlobal);
                        NumeroSumaiResta.setText(SumaiResta1);

                        NumeroSumaiResta2Global = (int) (Math.random()*100) + 1;
                        SumaiResta2 = String.valueOf(NumeroSumaiResta2Global);
                        Numero2SumaiResta.setText(SumaiResta2);
                    }else{
                        contadoooooor=1;
                    }

                }



            }

    public void desmarcar(){

                corretgir.setVisibility(View.VISIBLE);
                puntuaciooooo.setVisibility(View.GONE);

                PosarSuma.getText().clear();
                PosarResta.getText().clear();
                PosarSumairesta.getText().clear();

                Correcto.setVisibility(View.GONE);
                Incorrecto.setVisibility(View.GONE);

                Correcto1.setVisibility(View.GONE);
                Incorrecto1.setVisibility(View.GONE);

                Correcto2.setVisibility(View.GONE);
                Incorrecto2.setVisibility(View.GONE);

            }


        public void buscarpuntuacio(){

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

        public void actualitzarpuntuacio(){

        if(puntuacioTotal >= dbpuntuacioTotal){

            db.collection("usuaris").document(id).update("puntuacio", puntuacioTotal);

        }


        }












}



