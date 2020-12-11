package com.example.matematiques;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Objects;


public class login extends AppCompatActivity {


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    EditText  email, password;

    String  gmail, pwd, Id;
    int Puntuacio = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_prova);
        Button btnlogin = (Button) findViewById(R.id.botonlogin);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();

            }
        });


    }

    public void login(){

        gmail=email.getText().toString().trim();
        pwd=password.getText().toString().trim();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(gmail, pwd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success");
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            Toast.makeText(login.this, "T'has registrat correctament.",
                                    Toast.LENGTH_SHORT).show();

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    MirarPersona();
                                }
                            }, 1000);



                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent (login.this, MainActivity.class);
                                    startActivityForResult(intent, 0);
                                    finish();
                                }
                            }, 1000);


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(login.this, "Error al autenticar-te.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });


    }

    private void MirarPersona() {

        db.collection("usuaris").whereEqualTo("email", gmail).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                        android.util.Log.d("TAG", document.getId() + " => " + document.getData());
                        Id=document.getId();
                        Puntuacio=Integer.parseInt(document.getData().get("puntuacio").toString());
                        ActualitzarPuntuacio();
                    }
                } else {
                    Log.d("TAG", "Error getting documents: ", task.getException());
                }
            }
        });

    }

    private void ActualitzarPuntuacio() {
        db.collection("usuaris").document(Id).update("puntuacio", 0);
    }
}