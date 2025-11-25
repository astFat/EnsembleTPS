package com.example.ensemble_tps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class EnvoieSmsActivity extends AppCompatActivity {

    private EditText numero, message;
    private Button btnEnvoie;
    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envoie_sms);
        numero = findViewById(R.id.numero);
        message = findViewById(R.id.message);
        btnEnvoie = findViewById(R.id.envoyer);
        btnEnvoie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(EnvoieSmsActivity.this,
                        Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(EnvoieSmsActivity.this,
                            new String[]{Manifest.permission.SEND_SMS},
                            PERMISSION_REQUEST_CODE);
                } else {
                    envoyerSMS();
                }
            }
        });
    }
    private void envoyerSMS() {
        String num = numero.getText().toString().trim();
        String msg = message.getText().toString().trim();
        if (!num.matches("\\+?[0-9]{4,15}")) {
            Toast.makeText(this, "Numéro invalide", Toast.LENGTH_SHORT).show();
            return;
        }
        if (msg.isEmpty()) {
            Toast.makeText(this, "Le message est vide", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(num, null, msg, null, null);
            numero.setText("");
            message.setText("");

            Toast.makeText(this, "SMS envoyé avec succès", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Erreur lors de l'envoi du SMS", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,@NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                envoyerSMS();
            } else {
                Toast.makeText(this, "Permission refusée", Toast.LENGTH_SHORT).show();
            }
        }
    }
}