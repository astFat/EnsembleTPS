package com.example.ensemble_tps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NumberPickerActivity extends AppCompatActivity {

    private NumberPicker numberPickerJour;
    private Button btnValider;
    private TextView tvResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker);

        numberPickerJour = findViewById(R.id.numberPickerJour);
        btnValider = findViewById(R.id.btnValider);
        tvResultat = findViewById(R.id.tvResultat);

        numberPickerJour.setMinValue(1);
        numberPickerJour.setMaxValue(31);
        numberPickerJour.setValue(1);
        numberPickerJour.setWrapSelectorWheel(true);

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int jour = numberPickerJour.getValue();

                tvResultat.setText("Numéro sélectionné :\n" + jour);

                Toast.makeText(
                        NumberPickerActivity.this,
                        "Vous avez choisi : " + jour,
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}
