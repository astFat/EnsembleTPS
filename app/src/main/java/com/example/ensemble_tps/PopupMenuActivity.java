package com.example.ensemble_tps;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PopupMenuActivity extends AppCompatActivity {

    private Button btnShowMenu;
    private TextView tvSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

        btnShowMenu = findViewById(R.id.btnShowMenu);
        tvSelection = findViewById(R.id.tvSelection);

        btnShowMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);

        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.menu_option1) {
                    tvSelection.setText("Vous etes en Semestre 1");
                    Toast.makeText(PopupMenuActivity.this, "Semestre 1 sélectionnée", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.menu_option2) {
                    tvSelection.setText("Vous etes en Semestre 2");
                    Toast.makeText(PopupMenuActivity.this, "Semestre 2 sélectionnée", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.menu_option3) {
                    tvSelection.setText("Vous etes en Semestre 3");
                    Toast.makeText(PopupMenuActivity.this, "Semestre 3 sélectionnée", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.menu_option4) {
                    tvSelection.setText("Vvous etes en Semestre 4");
                    Toast.makeText(PopupMenuActivity.this, "Semestre 4 sélectionnée", Toast.LENGTH_SHORT).show();
                    return true;
                }else if (id == R.id.menu_quitter) {
                    Toast.makeText(PopupMenuActivity.this, "Fermeture...", Toast.LENGTH_SHORT).show();
                    finish();
                    return true;
                }
                return false;
            }
        });

        // Afficher le menu
        popupMenu.show();
    }
}