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
        TextView textView = findViewById(R.id.question);
        Button buttonOui = findViewById(R.id.buttonOui);
        Button buttonNon = findViewById(R.id.buttonNon);
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null && bundle.containsKey("titre") &&
                bundle.containsKey("description")) {
            titre = bundle.getString("titre");
            description = bundle.getString("description");
            position = bundle.getInt("position", 0);

            textView.setText(description);
        }
        buttonOui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(position + 1, intent);
                finish();
            }
        });
        buttonNon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(position + 5, intent);
                finish();
            }
        });
    }
}