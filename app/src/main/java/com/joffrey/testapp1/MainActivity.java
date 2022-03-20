package com.joffrey.testapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Elements de l'application mobile(boutons,zone de saisie)
    private TextView saisirLbl;
    private EditText prenomSaisi;
    private Button btnValider;
    private Intent intent;
    private String prenom;
    private Animation bounce,rotate;


    //Lancement de l'application
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.saisirLbl = findViewById(R.id.saisir_lbl);
        this.prenomSaisi = findViewById(R.id.prenom_saisi);
        this.btnValider = findViewById(R.id.btn_valider);

        //Initialition et exécution des animations sur les éléments de l 'application.
        bounce = AnimationUtils
                .loadAnimation(getApplicationContext(), R.anim.bounce);
        rotate = AnimationUtils
                .loadAnimation(getApplicationContext(), R.anim.rotate);
        saisirLbl
                .startAnimation(bounce);
        btnValider
                .startAnimation(rotate);
    }

    //Fonction de type listener,permettant de faire une action quand l'utilisatteur clique sur le bouton Valider.
    public void validerBouton(View view) {
        intent = new Intent(this,WowActivity.class);
        prenom = prenomSaisi.getText()
                                .toString();
        intent.putExtra("PRENOM",prenom);
        startActivity(intent);
    }
}
