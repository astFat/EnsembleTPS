package com.example.ensemble_tps;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatriceActivity extends AppCompatActivity {

    private EditText ecran;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnPlus, btnMinus, btnMultiply, btnDivide, btnEquals, btnClear, btnPoint;

    private double chiffre1 = 0;
    private String operateur = "";
    private boolean clicOperateur = false;
    private boolean nouveauNombre = true; // Pour gérer correctement les nouveaux nombres

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

        // Récupération de l'écran
        ecran = findViewById(R.id.ecran);

        // Récupération des boutons chiffres
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnPoint = findViewById(R.id.btnPoint);

        // Récupération des boutons opérateurs
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnEquals = findViewById(R.id.btnEquals);
        btnClear = findViewById(R.id.btnClear);

        // Attribution des écouteurs pour les chiffres
        View.OnClickListener chiffresListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                chiffresClick(button.getText().toString());
            }
        };

        btn0.setOnClickListener(chiffresListener);
        btn1.setOnClickListener(chiffresListener);
        btn2.setOnClickListener(chiffresListener);
        btn3.setOnClickListener(chiffresListener);
        btn4.setOnClickListener(chiffresListener);
        btn5.setOnClickListener(chiffresListener);
        btn6.setOnClickListener(chiffresListener);
        btn7.setOnClickListener(chiffresListener);
        btn8.setOnClickListener(chiffresListener);
        btn9.setOnClickListener(chiffresListener);

        // Bouton point décimal
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valeur = ecran.getText().toString();

                // Si c'est un nouveau nombre, commencer par "0."
                if (nouveauNombre) {
                    ecran.setText("0.");
                    nouveauNombre = false;
                } else if (!valeur.contains(".")) {
                    // Ajouter le point seulement s'il n'existe pas déjà
                    ecran.setText(valeur + ".");
                }
            }
        });

        // Opérateurs
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateurClick("+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateurClick("-");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateurClick("*");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operateurClick("/");
            }
        });

        // Bouton =
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcul();
                operateur = "";
                clicOperateur = false;
            }
        });

        // Bouton Clear
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ecran.setText("0");
                chiffre1 = 0;
                operateur = "";
                clicOperateur = false;
                nouveauNombre = true;
            }
        });
    }

    // Méthode pour gérer l'affichage des chiffres
    public void chiffresClick(String chiffre) {
        String valeurEcran = ecran.getText().toString();

        if (nouveauNombre || valeurEcran.equals("0")) {
            // Si c'est un nouveau nombre ou si l'écran affiche "0"
            ecran.setText(chiffre);
            nouveauNombre = false;
        } else {
            // Ajouter le chiffre à la fin
            ecran.setText(valeurEcran + chiffre);
        }
    }

    // Méthode unifiée pour gérer tous les opérateurs
    public void operateurClick(String op) {
        try {
            // Si un opérateur a déjà été cliqué, effectuer le calcul précédent
            if (clicOperateur && !nouveauNombre) {
                calcul();
            }

            // Sauvegarder le nombre actuel
            String valeurEcran = ecran.getText().toString();

            // Gérer le cas où l'utilisateur tape un point sans chiffre avant
            if (valeurEcran.endsWith(".")) {
                valeurEcran = valeurEcran + "0";
            }

            chiffre1 = Double.parseDouble(valeurEcran);
            operateur = op;
            clicOperateur = true;
            nouveauNombre = true; // Prêt pour le prochain nombre

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Erreur de format", Toast.LENGTH_SHORT).show();
        }
    }

    // Méthode pour effectuer le calcul
    private void calcul() {
        try {
            String valeurEcran = ecran.getText().toString();

            // Gérer le cas où l'utilisateur tape un point sans chiffre avant
            if (valeurEcran.endsWith(".")) {
                valeurEcran = valeurEcran + "0";
            }

            // Vérifier que l'écran n'est pas vide
            if (valeurEcran.isEmpty()) {
                valeurEcran = "0";
            }

            double chiffre2 = Double.parseDouble(valeurEcran);
            double resultat = 0;
            boolean erreur = false;

            // Effectuer l'opération selon l'opérateur
            switch (operateur) {
                case "+":
                    resultat = chiffre1 + chiffre2;
                    break;
                case "-":
                    resultat = chiffre1 - chiffre2;
                    break;
                case "*":
                    resultat = chiffre1 * chiffre2;
                    break;
                case "/":
                    if (chiffre2 == 0) {
                        ecran.setText("Erreur");
                        Toast.makeText(this, "Division par zéro impossible",
                                Toast.LENGTH_SHORT).show();
                        erreur = true;
                        nouveauNombre = true;
                    } else {
                        resultat = chiffre1 / chiffre2;
                    }
                    break;
                default:
                    resultat = chiffre2;
                    break;
            }

            // Afficher le résultat
            if (!erreur) {
                // Formater le résultat pour éviter les .0 inutiles
                if (resultat == (long) resultat) {
                    ecran.setText(String.valueOf((long) resultat));
                } else {
                    ecran.setText(String.valueOf(resultat));
                }
                chiffre1 = resultat;
                nouveauNombre = true;
            }

        } catch (NumberFormatException e) {
            ecran.setText("Erreur");
            Toast.makeText(this, "Erreur de calcul", Toast.LENGTH_SHORT).show();
            nouveauNombre = true;
        }
    }
}