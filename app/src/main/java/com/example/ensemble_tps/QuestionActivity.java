package com.example.ensemble_tps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {

    private String titre;
    private String description;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // Récupération des éléments
        TextView textView = findViewById(R.id.question);
        Button buttonOui = findViewById(R.id.buttonOui);
        Button buttonNon = findViewById(R.id.buttonNon);

        // Récupération du Bundle
        Bundle bundle = this.getIntent().getExtras();

        if (bundle != null && bundle.containsKey("titre") &&
                bundle.containsKey("description")) {
            titre = bundle.getString("titre");
            description = bundle.getString("description");
            position = bundle.getInt("position", 0);

            // Affichage de la question
            textView.setText(description);
        }

        // Bouton OUI
        buttonOui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                // Codes de résultat : 1-4 pour OUI
                setResult(position + 1, intent);
                finish();
            }
        });

        // Bouton NON
        buttonNon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                // Codes de résultat : 5-8 pour NON
                setResult(position + 5, intent);
                finish();
            }
        });
    }
}