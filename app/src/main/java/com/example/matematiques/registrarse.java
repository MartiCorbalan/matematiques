package com.example.matematiques;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;




public class registrarse<EmailPasswordActivity> extends AppCompatActivity {

    private static final String TAG = null;

    EditText username, email, password;

    String nom, gmail, pwd;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.registrarse);
        mAuth = FirebaseAuth.getInstance();

        Button btnlogin = (Button) findViewById(R.id.botonlogin);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        final EditText usuari = (EditText) findViewById(R.id.username);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registrarUsuari();

            }


        });


    }

    public void registrarUsuari(){

        nom=username.getText().toString().trim();
        gmail=email.getText().toString().trim();
        pwd=password.getText().toString().trim();

        if (TextUtils.isEmpty(nom)){
            Toast.makeText(this, "Has de posar un nom d'usuari",Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(gmail)){
            Toast.makeText(this, "Has d'ingressar un Email",Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(pwd)){
            Toast.makeText(this, "Has d'ingressar una contrassenya",Toast.LENGTH_LONG).show();
            return;
        }



        Map<String, Object> user = new HashMap<>();
        user.put("usuari", nom);
        user.put("email", gmail);
        user.put("puntuacio", 0);



        mAuth.createUserWithEmailAndPassword(gmail, pwd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

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
                           Toast.makeText(registrarse.this, "S'ha registrat el email",Toast.LENGTH_LONG).show();
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());

                            Toast.makeText(registrarse.this, "No s'ha pogut registrar l'usuari ",Toast.LENGTH_LONG).show();

                        }

                    }
                });

        Intent intent = new Intent(registrarse.this, MainActivity.class);
        Bundle b = new Bundle();
        b.putString ("usuaris",nom);
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }

}