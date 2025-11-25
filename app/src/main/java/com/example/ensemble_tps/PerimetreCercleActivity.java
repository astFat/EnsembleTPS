package com.example.ensemble_tps;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PerimetreCercleActivity extends AppCompatActivity {

    private EditText etRayon;
    private TextView tvResultat;
    private Button btnCalculer;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perimetre_cercle);
        etRayon = findViewById(R.id.etRayon);
        tvResultat = findViewById(R.id.tvResultat);
        btnCalculer = findViewById(R.id.btnCalculer);
        btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rayonStr = etRayon.getText().toString().trim();
                if (rayonStr.isEmpty()) {
                    Toast.makeText(PerimetreCercleActivity.this,"Veuillez entrer le rayon", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    double rayon = Double.parseDouble(rayonStr);
                    double perimetre = 2 * 3.14 * rayon;
                    String resultat = String.format("Résultat : %.2f", perimetre);
                    tvResultat.setText(resultat);
                    Toast.makeText(PerimetreCercleActivity.this,
                            resultat, Toast.LENGTH_LONG).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(PerimetreCercleActivity.this,
                            "Valeur invalide",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}