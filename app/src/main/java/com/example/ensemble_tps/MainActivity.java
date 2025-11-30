package com.example.ensemble_tps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<ExerciceItem> exercices;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        exercices = new ArrayList<>();
        exercices.add(new ExerciceItem("TP1 - Exercice 1 : ProjetClick", R.drawable.ic_click));
        exercices.add(new ExerciceItem("TP1 - Exercice 2 : Consommation Carburant", R.drawable.ic_fuel));
        exercices.add(new ExerciceItem("TP1 - Exercice 3 : Convertisseur Température", R.drawable.ic_temperature));
        exercices.add(new ExerciceItem("TP1 - Exercice 4 : Saisie Étudiant", R.drawable.ic_management));
        exercices.add(new ExerciceItem("TP2 - Exercice 1 : Périmètre Cercle", R.drawable.ic_circle));
        exercices.add(new ExerciceItem("TP2 - Exercice 2 : Convertisseur Devises", R.drawable.ic_currency));
        exercices.add(new ExerciceItem("TP2 - Exercice 3 : Gestion Étudiant", R.drawable.ic_management));
        exercices.add(new ExerciceItem("TP3 - Application Calculatrice", R.drawable.ic_calculator));
        exercices.add(new ExerciceItem("TP4 - Envoi de SMS", R.drawable.ic_sms));
        exercices.add(new ExerciceItem("TP4 - Menu Options Android", R.drawable.ic_menu));
        exercices.add(new ExerciceItem("TP5 - ListView Personnalisée", R.drawable.ic_micr));
        exercices.add(new ExerciceItem("TP5 - Navigation avec Intent", R.drawable.ic_navigation));
        exercices.add(new ExerciceItem("TP6 - PopupMenu Android", R.drawable.ic_popup));
        exercices.add(new ExerciceItem("TP6 - NumberPicker Android", R.drawable.ic_number));

        ExerciceAdapter adapter = new ExerciceAdapter(this, exercices);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;

                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, ProjetClickActivity.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, ConsommationCarburantActivity.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, ConvertisseurTemperatureActivity.class);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, SaisieEtudiantActivity.class);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, PerimetreCercleActivity.class);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this, ConvertisseurDevisesActivity.class);
                        break;
                    case 6:
                        intent = new Intent(MainActivity.this, GestionEtudiantActivity.class);
                        break;
                    case 7:
                        intent = new Intent(MainActivity.this, CalculatriceActivity.class);
                        break;
                    case 8:
                        intent = new Intent(MainActivity.this, EnvoieSmsActivity.class);
                        break;
                    case 9:
                        intent = new Intent(MainActivity.this, MenuOptionsActivity.class);
                        break;
                    case 10:
                        intent = new Intent(MainActivity.this, ListViewPersoActivity.class);
                        break;
                    case 11:
                        intent = new Intent(MainActivity.this, NavigationIntentActivity.class);
                        break;
                    case 12:
                        intent = new Intent(MainActivity.this, PopupMenuActivity.class);
                        break;
                    case 13:
                        intent = new Intent(MainActivity.this, NumberPickerActivity.class);
                        break;
                }

                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }
}