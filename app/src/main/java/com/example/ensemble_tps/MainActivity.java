package com.example.ensemble_tps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Déclaration des boutons
    private Button btnExo1Tp1, btnExo2Tp1, btnExo3Tp1, btnExo4Tp1;
    private Button btnExo1Tp2, btnExo2Tp2, btnExo3Tp2;
    private Button btnCalculatrice;
    private Button btnEnvoiSms, btnMenuOptions;
    private Button btnListViewPerso, btnNavigationIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       
        btnExo1Tp1 = findViewById(R.id.btnExo1Tp1);
        btnExo2Tp1 = findViewById(R.id.btnExo2Tp1);
        btnExo3Tp1 = findViewById(R.id.btnExo3Tp1);
        btnExo4Tp1 = findViewById(R.id.btnExo4Tp1);

        // Exercice 1 : ProjetClick
        btnExo1Tp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProjetClickActivity.class);
                startActivity(intent);
            }
        });

        // Exercice 2 : Consommation Carburant
        btnExo2Tp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConsommationCarburantActivity.class);
                startActivity(intent);
            }
        });

        // Exercice 3 : Convertisseur Température
        btnExo3Tp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConvertisseurTemperatureActivity.class);
                startActivity(intent);
            }
        });

        // Exercice 4 : Saisie Étudiant
        btnExo4Tp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SaisieEtudiantActivity.class);
                startActivity(intent);
            }
        });

        // ========================================
        // SECTION 2 : TP 2 - Android XML
        // ========================================
        btnExo1Tp2 = findViewById(R.id.btnExo1Tp2);
        btnExo2Tp2 = findViewById(R.id.btnExo2Tp2);
        btnExo3Tp2 = findViewById(R.id.btnExo3Tp2);

        // Exercice 1 : Périmètre Cercle
        btnExo1Tp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PerimetreCercleActivity.class);
                startActivity(intent);
            }
        });

        // Exercice 2 : Convertisseur Devises
        btnExo2Tp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConvertisseurDevisesActivity.class);
                startActivity(intent);
            }
        });

        // Exercice 3 : Gestion Étudiant
        btnExo3Tp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestionEtudiantActivity.class);
                startActivity(intent);
            }
        });

        // ========================================
        // SECTION 3 : TP 3 - Calculatrice
        // ========================================
        btnCalculatrice = findViewById(R.id.btnCalculatrice);

        btnCalculatrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculatriceActivity.class);
                startActivity(intent);
            }
        });

        // ========================================
        // SECTION 4 : TP 4 - SMS et Menus
        // ========================================
        btnEnvoiSms = findViewById(R.id.btnEnvoiSms);
        btnMenuOptions = findViewById(R.id.btnMenuOptions);

        // Envoi SMS
        btnEnvoiSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EnvoieSmsActivity.class);
                startActivity(intent);
            }
        });

        // Menu Options
        btnMenuOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuOptionsActivity.class);
                startActivity(intent);
            }
        });

        // ========================================
        // SECTION 5 : TP 5 - ListView et Navigation
        // ========================================
        btnListViewPerso = findViewById(R.id.btnListViewPerso);
        btnNavigationIntent = findViewById(R.id.btnNavigationIntent);

        // ListView Personnalisée
        btnListViewPerso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewPersoActivity.class);
                startActivity(intent);
            }
        });

        // Navigation avec Intent
        btnNavigationIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NavigationIntentActivity.class);
                startActivity(intent);
            }
        });
    }
}