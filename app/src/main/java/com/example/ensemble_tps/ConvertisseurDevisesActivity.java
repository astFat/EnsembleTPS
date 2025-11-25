package com.example.ensemble_tps;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ConvertisseurDevisesActivity extends AppCompatActivity {

    private EditText etMAD;
    private TextView tvUSD, tvEUR, tvMAD;
    private Button btnConvertir, btnReset;
    private final double EURO_TO_MAD = 10.69;
    private final double USD_TO_MAD = 9.85;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertisseur_devises);
        etMAD = findViewById(R.id.etMAD);
        tvUSD = findViewById(R.id.tvUSD);
        tvEUR = findViewById(R.id.tvEUR);
        tvMAD = findViewById(R.id.tvMAD);
        btnConvertir = findViewById(R.id.btnConvertir);
        btnReset = findViewById(R.id.btnReset);
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String madStr = etMAD.getText().toString().trim();
                if (madStr.isEmpty()) {
                    Toast.makeText(ConvertisseurDevisesActivity.this,
                            "Veuillez entrer un montant",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    double mad = Double.parseDouble(madStr);
                    double usdValue = mad / USD_TO_MAD;
                    double eurValue = mad / EURO_TO_MAD;
                    tvUSD.setText(String.format("USD : %.2f", usdValue));
                    tvEUR.setText(String.format("EUR : %.2f", eurValue));
                    tvMAD.setText(String.format("MAD : %.2f", mad));
                } catch (NumberFormatException e) {
                    Toast.makeText(ConvertisseurDevisesActivity.this,
                            "Valeur invalide",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etMAD.setText("");
                tvUSD.setText("USD : 0.00");
                tvEUR.setText("EUR : 0.00");
                tvMAD.setText("MAD : 0.00");
            }
        });
    }
}
