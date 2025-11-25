package com.example.ensemble_tps;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MenuOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_options);
    }

    // Méthode pour créer le menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Charger le menu depuis le fichier XML
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    // Méthode pour gérer les clics sur les items du menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.itemSettings) {
            // Action pour Paramètres
            Toast.makeText(this, "Paramètres sélectionnés",
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.itemQuitter) {
            // Action pour Quitter
            Toast.makeText(this, "Fermeture de l'application",
                    Toast.LENGTH_SHORT).show();
            finish(); // Ferme l'activité
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}