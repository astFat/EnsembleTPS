package com.example.ensemble_tps;

public class ExerciceItem {
    private String titre;
    private int iconResId;

    public ExerciceItem(String titre, int iconResId) {
        this.titre = titre;
        this.iconResId = iconResId;
    }

    public String getTitre() {
        return titre;
    }

    public int getIconResId() {
        return iconResId;
    }
}