package com.joffrey.testapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class WowActivity extends AppCompatActivity {


    //Initialisation des éléments de l'application
    private Intent intent,intent2;
    private VideoView video;
    private Button relancer_bouton;
    private TextView afficher_valeur;
    private Animation bounce,rotate,zoom_in;


    //Lancement de l'application
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initialisation des animations
        bounce = AnimationUtils
                .loadAnimation(getApplicationContext(), R.anim.bounce);
        rotate = AnimationUtils
                .loadAnimation(getApplicationContext(), R.anim.rotate);
        zoom_in = AnimationUtils
                .loadAnimation(getApplicationContext(), R.anim.zoom_out);

        intent = getIntent();
        intent2 = new Intent(WowActivity.this,MainActivity.class);

        String prenom = intent.getStringExtra("PRENOM");

        setContentView(R.layout.activity_wow);

        relancer_bouton = findViewById(R.id.relancer_bouton);
            relancer_bouton.startAnimation(rotate);

        afficher_valeur = findViewById(R.id.afficher_valeur);
            afficher_valeur.startAnimation(bounce);

        video = (VideoView) findViewById(R.id.vw_afficher);
            video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videotest));
                video.start();


        afficher_valeur.setText("Hello World!" + prenom);

    }

    private void btnRelancer(View view){
        video.startAnimation(rotate);
        startActivity(intent2);
    }



}