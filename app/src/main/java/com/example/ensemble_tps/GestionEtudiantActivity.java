package com.example.ensemble_tps;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class GestionEtudiantActivity extends AppCompatActivity {

    private EditText etPrenom, etNom, etEmail, etMoyenne;
    private RadioGroup rgAnnee;
    private RadioButton rb1, rb2;
    private Spinner spinnerMatiere;
    private Button btnEnregistrer;
    private WebView webResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_etudiant);

        // Récupération des éléments
        etPrenom = findViewById(R.id.etPrenom);
        etNom = findViewById(R.id.etNom);
        etEmail = findViewById(R.id.etEmail);
        etMoyenne = findViewById(R.id.etMoyenne);
        rgAnnee = findViewById(R.id.rgAnnee);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        spinnerMatiere = findViewById(R.id.spinnerMatiere);
        btnEnregistrer = findViewById(R.id.btnEnregistrer);
        webResult = findViewById(R.id.webResult);

        // Configuration du Spinner
        String[] matieres = {"Informatique", "Mathématiques", "Physique", "Chimie"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, matieres);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMatiere.setAdapter(adapter);

        // Configuration du WebView
        WebSettings webSettings = webResult.getSettings();
        webSettings.setBuiltInZoomControls(false);
        webSettings.setJavaScriptEnabled(false);

        // Bouton Enregistrer
        btnEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupération des données
                String prenom = etPrenom.getText().toString().trim();
                String nom = etNom.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String moyenneStr = etMoyenne.getText().toString().trim();

                // Validation
                if (prenom.isEmpty() || nom.isEmpty() || email.isEmpty() || moyenneStr.isEmpty()) {
                    Toast.makeText(GestionEtudiantActivity.this,
                            "Veuillez remplir tous les champs",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validation email
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(GestionEtudiantActivity.this,
                            "Email invalide",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double moyenne = Double.parseDouble(moyenneStr);

                    // Récupération de l'année
                    int annee = 1;
                    int selectedId = rgAnnee.getCheckedRadioButtonId();
                    if (selectedId == R.id.rb2) {
                        annee = 2;
                    }

                    // Récupération de la matière
                    String matiere = spinnerMatiere.getSelectedItem().toString();

                    // Création de l'objet Etudiant
                    Etudiant etudiant = new Etudiant(prenom, nom, email, annee, matiere, moyenne);

                    // Génération du HTML
                    String html = buildHtmlTable(etudiant);

                    // Affichage dans WebView
                    webResult.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);

                    Toast.makeText(GestionEtudiantActivity.this,
                            "Étudiant enregistré avec succès !",
                            Toast.LENGTH_SHORT).show();

                } catch (NumberFormatException e) {
                    Toast.makeText(GestionEtudiantActivity.this,
                            "Moyenne invalide",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Méthode pour générer le HTML
    private String buildHtmlTable(Etudiant etudiant) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html><html><head>");
        html.append("<style>");
        html.append("body { font-family: Arial; padding: 10px; }");
        html.append("table { width: 100%; border-collapse: collapse; }");
        html.append("th, td { border: 1px solid #333; padding: 10px; text-align: left; }");
        html.append("th { background-color: #4CAF50; color: white; }");
        html.append(".highlight { background-color: #FFD700; }");
        html.append("</style></head><body>");

        html.append("<h2>Informations Étudiant</h2>");
        html.append("<table>");
        html.append(cell("Prénom", escape(etudiant.getPrenom()), false));
        html.append(cell("Nom", escape(etudiant.getNom()), false));
        html.append(cell("Email", escape(etudiant.getMail()), false));
        html.append(cell("Année", etudiant.getAnnee() + "ème année", false));
        html.append(cell("Matière", escape(etudiant.getMatiere()), false));
        html.append(cell("Moyenne", String.format("%.2f", etudiant.getMoyenne()),
                etudiant.getMoyenne() >= 10));
        html.append("</table>");

        html.append("</body></html>");
        return html.toString();
    }

    // Méthode helper pour créer une ligne de tableau
    private String cell(String label, String value, boolean highlight) {
        String classe = highlight ? " class='highlight'" : "";
        return "<tr" + classe + "><th>" + label + "</th><td>" + value + "</td></tr>";
    }

    // Méthode pour échapper les caractères HTML
    private String escape(String text) {
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}