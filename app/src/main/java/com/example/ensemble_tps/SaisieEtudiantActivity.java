package com.example.ensemble_tps;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SaisieEtudiantActivity extends AppCompatActivity {

    private EditText etCNE, etPrenom, etNom, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ScrollView
        ScrollView scrollView = new ScrollView(this);
        scrollView.setFillViewport(true);
        scrollView.setBackgroundColor(0xFFF5F5F5); // gris très clair

        // Layout principal
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 50, 40, 40);

        GradientDrawable editStyle = new GradientDrawable();
        editStyle.setCornerRadius(18);
        editStyle.setColor(0xFFEEEEEE); // gris clair
        editStyle.setStroke(2, 0xFFCCCCCC);

        // -------- TITRE --------
        TextView tvTitre = new TextView(this);
        tvTitre.setText("Saisie Informations Étudiant");
        tvTitre.setTextSize(22);
        tvTitre.setTextColor(0xFF555555); // gris foncé
        tvTitre.setGravity(Gravity.CENTER);
        tvTitre.setPadding(0, 30, 0, 20);
        layout.addView(tvTitre);

        // ====== FONCTION POUR CRÉER LABEL + CHAMP =====
        layout.addView(createLabel("CNE :"));
        etCNE = createInput("Entrez le CNE", editStyle);
        layout.addView(etCNE);

        layout.addView(createLabel("Prénom :"));
        etPrenom = createInput("Entrez le prénom", editStyle);
        layout.addView(etPrenom);

        layout.addView(createLabel("Nom :"));
        etNom = createInput("Entrez le nom", editStyle);
        layout.addView(etNom);

        layout.addView(createLabel("Email :"));
        etEmail = createInput("Entrez l'email", editStyle);
        etEmail.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        layout.addView(etEmail);

        // -------- BOUTON --------
        Button btnAfficher = new Button(this);
        btnAfficher.setText("AFFICHER LES INFORMATIONS");
        btnAfficher.setBackgroundColor(0xFFBDBDBD); // gris bouton
        btnAfficher.setTextColor(0xFF000000); // texte noir
        btnAfficher.setAllCaps(true);

        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        btnParams.setMargins(0, 40, 0, 30);
        btnAfficher.setLayoutParams(btnParams);

        // Action bouton
        btnAfficher.setOnClickListener(v -> {
            String cne = etCNE.getText().toString().trim();
            String prenom = etPrenom.getText().toString().trim();
            String nom = etNom.getText().toString().trim();
            String email = etEmail.getText().toString().trim();

            if (cne.isEmpty() || prenom.isEmpty() || nom.isEmpty() || email.isEmpty()) {
                showToastCenter("⚠️ Veuillez remplir tous les champs");
                return;
            }

            String message = "✓ Informations saisies :\n\n" +
                    "CNE : " + cne + "\n" +
                    "Prénom : " + prenom + "\n" +
                    "Nom : " + nom + "\n" +
                    "Email : " + email;

            showToastCenter(message);
        });

        layout.addView(btnAfficher);
        scrollView.addView(layout);
        setContentView(scrollView);
    }

    // ====== MÉTHODES UTILITAIRES ======

    private TextView createLabel(String text) {
        TextView label = new TextView(this);
        label.setText(text);
        label.setTextSize(16);
        label.setTextColor(0xFF666666); // gris labels
        label.setPadding(0, 20, 0, 5);
        return label;
    }

    private EditText createInput(String hint, GradientDrawable bg) {
        EditText input = new EditText(this);
        input.setHint(hint);
        input.setPadding(30, 25, 30, 25);
        input.setBackground(bg);
        return input;
    }

    private void showToastCenter(String msg) {

        // Layout du toast
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 40, 40, 40);
        layout.setBackgroundColor(0xFF333333); // fond gris foncé
        layout.setMinimumWidth(700); // élargir le toast
        layout.setGravity(Gravity.CENTER);

        // Texte du toast
        TextView tv = new TextView(this);
        tv.setText(msg);
        tv.setTextColor(0xFFFFFFFF); // blanc
        tv.setTextSize(18);
        tv.setPadding(10, 10, 10, 10);
        tv.setMaxLines(10); // jusqu’à 10 lignes (important)

        layout.addView(tv);

        // Création du toast
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
