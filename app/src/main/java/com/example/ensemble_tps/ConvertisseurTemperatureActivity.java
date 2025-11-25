package com.example.ensemble_tps;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ConvertisseurTemperatureActivity extends AppCompatActivity {

    private EditText etTemperature;
    private RadioGroup radioGroup;
    private RadioButton rbCelsiusToFahr, rbFahrToCelsius;
    private TextView tvResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setBackgroundColor(Color.CYAN);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.TOP);
        layout.setPadding(40, 40, 40, 40);
        TextView tvTitre = new TextView(this);
        tvTitre.setText("Convertisseur\nCelsius - Fahrenheit");
        tvTitre.setTextColor(Color.RED);
        tvTitre.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        tvTitre.setTypeface(null, Typeface.BOLD_ITALIC);
        tvTitre.setGravity(Gravity.CENTER);
        tvTitre.setPadding(0, 0, 0, 20);
        tvTitre.setMaxLines(2);
        layout.addView(tvTitre);
        etTemperature = new EditText(this);
        etTemperature.setHint("Température");
        etTemperature.setInputType(android.text.InputType.TYPE_CLASS_NUMBER |
                android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL |
                android.text.InputType.TYPE_NUMBER_FLAG_SIGNED);
        layout.addView(etTemperature);
        radioGroup = new RadioGroup(this);
        radioGroup.setOrientation(RadioGroup.VERTICAL);
        radioGroup.setPadding(0, 20, 0, 20);

        rbCelsiusToFahr = new RadioButton(this);
        rbCelsiusToFahr.setText("Celsius → Fahrenheit");
        rbCelsiusToFahr.setId(View.generateViewId());
        radioGroup.addView(rbCelsiusToFahr);
        rbFahrToCelsius = new RadioButton(this);
        rbFahrToCelsius.setText("Fahrenheit → Celsius");
        rbFahrToCelsius.setId(View.generateViewId());
        radioGroup.addView(rbFahrToCelsius);
        radioGroup.check(rbCelsiusToFahr.getId());
        layout.addView(radioGroup);
        tvResultat = new TextView(this);
        tvResultat.setText("Résultat : ");
        tvResultat.setTextSize(18);
        tvResultat.setPadding(0, 20, 0, 20);
        layout.addView(tvResultat);
        Button btnConvertir = new Button(this);
        btnConvertir.setText("Convertir");
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etTemperature.getText().toString().trim();
                if (input.isEmpty()) {
                    Toast.makeText(ConvertisseurTemperatureActivity.this,
                            "Veuillez entrer une température !", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    double valeur = Double.parseDouble(input);
                    double resultat;
                    if (rbCelsiusToFahr.isChecked()) {
                        resultat = (valeur * 9.0 / 5.0) + 32;
                        tvResultat.setText(String.format("Résultat : %.2f °F", resultat));
                    } else if (rbFahrToCelsius.isChecked()) {
                        resultat = (valeur - 32) / 1.8;
                        tvResultat.setText(String.format("Résultat : %.2f °C", resultat));
                    } else {
                        Toast.makeText(ConvertisseurTemperatureActivity.this,
                                "Veuillez sélectionner une option !", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(ConvertisseurTemperatureActivity.this,
                            "Erreur : format de nombre invalide !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        layout.addView(btnConvertir);

        setContentView(layout);
    }
}