package com.example.ensemble_tps;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ConsommationCarburantActivity extends AppCompatActivity {

    private EditText etSaisie;
    private TextView tvResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Constantes de conversion
        final double GALLON_TO_LITERS = 3.785;
        final double MILE_TO_KM = 1.609;

        // Layout principal
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.TOP);
        layout.setPadding(40, 40, 40, 40);

        // Titre
        TextView tvTitre = new TextView(this);
        tvTitre.setText("Convertisseur de Consommation\nVéhicule");
        tvTitre.setTextSize(24);
        tvTitre.setGravity(Gravity.CENTER_HORIZONTAL);
        tvTitre.setPadding(0, 0, 0, 20);
        tvTitre.setMaxLines(2);  // ✅ AJOUTÉ
        tvTitre.setSingleLine(false);  // ✅ AJOUTÉ

        LinearLayout.LayoutParams paramsTitle = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        tvTitre.setLayoutParams(paramsTitle);  // ✅ AJOUTÉ

        layout.addView(tvTitre);

        // Champ de saisie
        etSaisie = new EditText(this);
        etSaisie.setHint("Entrez la valeur");
        etSaisie.setInputType(android.text.InputType.TYPE_CLASS_NUMBER |
                android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL);
        layout.addView(etSaisie);

        // TextView résultat
        tvResultat = new TextView(this);
        tvResultat.setText("Résultat : ");
        tvResultat.setTextSize(18);
        tvResultat.setPadding(0, 20, 0, 20);
        layout.addView(tvResultat);

        // Bouton MPG -> L/100km
        Button btnMpgToL100 = new Button(this);
        btnMpgToL100.setText("MPG → L/100km");
        btnMpgToL100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double mpg = Double.parseDouble(etSaisie.getText().toString());
                    double l100km = (100 * GALLON_TO_LITERS) / (mpg * MILE_TO_KM);
                    tvResultat.setText(String.format("Résultat : %.2f L/100km", l100km));
                } catch (Exception e) {
                    Toast.makeText(ConsommationCarburantActivity.this,
                            "Erreur de saisie !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        layout.addView(btnMpgToL100);

        // Bouton L/100km -> MPG
        Button btnL100ToMpg = new Button(this);
        btnL100ToMpg.setText("L/100km → MPG");
        btnL100ToMpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double l100km = Double.parseDouble(etSaisie.getText().toString());
                    double mpg = (100 * GALLON_TO_LITERS) / (l100km * MILE_TO_KM);
                    tvResultat.setText(String.format("Résultat : %.2f MPG", mpg));
                } catch (Exception e) {
                    Toast.makeText(ConsommationCarburantActivity.this,
                            "Erreur de saisie !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        layout.addView(btnL100ToMpg);

        // Bouton Effacer
        Button btnEffacer = new Button(this);
        btnEffacer.setText("Effacer");
        btnEffacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSaisie.setText("");
                tvResultat.setText("Résultat : ");
            }
        });
        layout.addView(btnEffacer);

        setContentView(layout);
    }
}