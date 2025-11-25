package com.example.ensemble_tps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

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
        btnExo1Tp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProjetClickActivity.class);
                startActivity(intent);
            }
        });
        btnExo2Tp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConsommationCarburantActivity.class);
                startActivity(intent);
            }
        });
        btnExo3Tp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConvertisseurTemperatureActivity.class);
                startActivity(intent);
            }
        });
        btnExo4Tp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SaisieEtudiantActivity.class);
                startActivity(intent);
            }
        });
        btnExo1Tp2 = findViewById(R.id.btnExo1Tp2);
        btnExo2Tp2 = findViewById(R.id.btnExo2Tp2);
        btnExo3Tp2 = findViewById(R.id.btnExo3Tp2);
        btnExo1Tp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PerimetreCercleActivity.class);
                startActivity(intent);
            }
        });
        btnExo2Tp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConvertisseurDevisesActivity.class);
                startActivity(intent);
            }
        });
        btnExo3Tp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestionEtudiantActivity.class);
                startActivity(intent);
            }
        });
        btnCalculatrice = findViewById(R.id.btnCalculatrice);
        btnCalculatrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculatriceActivity.class);
                startActivity(intent);
            }
        });
        btnEnvoiSms = findViewById(R.id.btnEnvoiSms);
        btnMenuOptions = findViewById(R.id.btnMenuOptions);
        btnEnvoiSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EnvoieSmsActivity.class);
                startActivity(intent);
            }
        });
        btnMenuOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuOptionsActivity.class);
                startActivity(intent);
            }
        });
        btnListViewPerso = findViewById(R.id.btnListViewPerso);
        btnNavigationIntent = findViewById(R.id.btnNavigationIntent);

        btnListViewPerso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewPersoActivity.class);
                startActivity(intent);
            }
        });
        btnNavigationIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NavigationIntentActivity.class);
                startActivity(intent);
            }
        });
    }
}