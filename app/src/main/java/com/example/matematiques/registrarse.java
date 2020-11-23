package com.example.matematiques;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class registrarse extends AppCompatActivity {
    private static final String TAG = null;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    EditText nom;
    EditText email;
    EditText contrasenya;



    String username;
    String gmail;
    String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        nom= findViewById(R.id.username);
        email=findViewById(R.id.email);
        contrasenya=findViewById(R.id.password);

        Button btnlogin =  findViewById(R.id.botonlogin);
        final EditText usuari = (EditText) findViewById(R.id.username);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = nom.getText().toString();
                gmail = email.getText().toString();
                pwd = contrasenya.getText().toString();
                Map<String, Object> user = new HashMap<>();

                user.put("usuari", username);
                user.put("email", gmail);
                user.put("password", pwd);

// Add a new document with a generated ID
                db.collection("usuaris")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });

                Intent intent = new Intent(registrarse.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putString ("usuari", String.valueOf(nom));
                intent.putExtras(b);
                startActivity(intent);



            }


        });




    }
}