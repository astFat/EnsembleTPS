package com.example.ensemble_tps;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProjetClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(40, 40, 40, 40);
        TextView tvInstruction = new TextView(this);
        tvInstruction.setText("ENTREZ VOTRE NOM !");
        tvInstruction.setTextSize(20);
        tvInstruction.setGravity(Gravity.CENTER);
        layout.addView(tvInstruction);
        final EditText editText = new EditText(this);
        editText.setHint("Répondre ici");
        editText.setGravity(Gravity.CENTER);
        layout.addView(editText);
        final TextView tvResult = new TextView(this);
        tvResult.setTextSize(18);
        tvResult.setGravity(Gravity.CENTER);
        tvResult.setPadding(0, 20, 0, 0);
        layout.addView(tvResult);
        final Button btnAfficher = new Button(this);
        btnAfficher.setText("AFFICHER");
        btnAfficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texte = editText.getText().toString();
                tvResult.setText(texte);
                btnAfficher.setText("Texte affiché !");
            }
        });
        layout.addView(btnAfficher);
        setContentView(layout);
    }
}