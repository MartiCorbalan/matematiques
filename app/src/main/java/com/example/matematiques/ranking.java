package com.example.matematiques;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Objects;

public class ranking extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String email = user.getEmail();

    String usuari;
    String puntuacio;

    TextView jugador1;
    TextView jugador2;
    TextView jugador3;
    TextView jugador4;
    TextView jugador5;

    TextView puntuacioo1;
    TextView puntuacioo2;
    TextView puntuacioo3;
    TextView puntuacioo4;
    TextView puntuacioo5;


    ArrayList<String> jugador = new ArrayList<String>();


    ArrayList<Integer> puntuacioRanking = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        buscarJugador();


        jugador1 = findViewById(R.id.j1);
        puntuacioo1 = findViewById(R.id.pt1);
        jugador2 = findViewById(R.id.j2);
        puntuacioo2 = findViewById(R.id.pt2);
        jugador3 = findViewById(R.id.j3);
        puntuacioo3 = findViewById(R.id.pt3);
        jugador4 = findViewById(R.id.j4);
        puntuacioo4 = findViewById(R.id.pt4);
        jugador5 = findViewById(R.id.j5);
        puntuacioo5 = findViewById(R.id.pt5);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

              jugador1.setText(jugador.get(0));
              puntuacioo1.setText(puntuacioRanking.get(0));

              jugador2.setText(jugador.get(1));
              puntuacioo2.setText(puntuacioRanking.get(1));

              jugador3.setText(jugador.get(2));
              puntuacioo3.setText(puntuacioRanking.get(2));

              jugador4.setText(jugador.get(3));
              puntuacioo4.setText(puntuacioRanking.get(3));

              jugador5.setText(jugador.get(4));
              puntuacioo5.setText(puntuacioRanking.get(4));

            }
        }, 1000);

    }
    private void buscarJugador() {
        db.collection("usuaris").whereEqualTo("email", email).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                        Log.d("TAG", document.getId() + " => " + document.getData());
                        jugador.add(document.getData().get("usuari").toString());
                        puntuacioRanking.add(Integer.parseInt(document.getData().get("puntuacio").toString()));
                    }
                } else {
                    Log.d("TAG", "Error getting documents: ", task.getException());
                }
            }
        });


        db.collection("usuaris").whereNotEqualTo("email", email).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                        Log.d("TAG", document.getId() + " => " + document.getData());
                        jugador.add(document.getData().get("usuari").toString());
                        puntuacioRanking.add(Integer.parseInt(document.getData().get("puntuacio").toString()));
                    }
                } else {
                    Log.d("TAG", "Error getting documents: ", task.getException());
                }
            }
        });


    }
}