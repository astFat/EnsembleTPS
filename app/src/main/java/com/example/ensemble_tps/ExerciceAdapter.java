package com.example.ensemble_tps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class ExerciceAdapter extends BaseAdapter {
    private Context context;
    private List<ExerciceItem> exercices;

    public ExerciceAdapter(Context context, List<ExerciceItem> exercices) {
        this.context = context;
        this.exercices = exercices;
    }

    @Override
    public int getCount() {
        return exercices.size();
    }

    @Override
    public Object getItem(int position) {
        return exercices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_exercice, parent, false);
            holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.exerciceIcon);
            holder.titre = convertView.findViewById(R.id.exerciceTitre);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ExerciceItem item = exercices.get(position);
        holder.icon.setImageResource(item.getIconResId());
        holder.titre.setText(item.getTitre());

        return convertView;
    }

    static class ViewHolder {
        ImageView icon;
        TextView titre;
    }
}