package com.example.matematiques;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

import java.util.ArrayList;



public class login extends AppCompatActivity {



    EditText  email, password;

    String  gmail, pwd;

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
                //crear toast per donar benvinguda a l'usuari
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
                                    Intent intent = new Intent (login.this, MainActivity.class);
                                    startActivityForResult(intent, 0);
                                }
                            }, 3000);


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(login.this, "Error al autenticar-te.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });


    }
}