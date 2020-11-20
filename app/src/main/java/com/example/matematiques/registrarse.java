package com.example.matematiques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registrarse extends AppCompatActivity {

    EditText nom;
    EditText email;
    EditText contrasenya;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        nom=(EditText)findViewById(R.id.username);
        email=findViewById(R.id.email);
        contrasenya=findViewById(R.id.password);

        Button btnlogin = (Button) findViewById(R.id.botonlogin);
        final EditText usuari = (EditText) findViewById(R.id.username);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom=usuari.getText().toString();

                Intent intent = new Intent(registrarse.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putString ("usuaris",nom);
                intent.putExtras(b);
                startActivity(intent);

            }


        });





    }
}