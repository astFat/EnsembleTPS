package com.example.ensemble_tps;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewPersoActivity extends AppCompatActivity {

    private ListView maListViewPerso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_perso);
        maListViewPerso = findViewById(R.id.listviewperso);
        ArrayList<ItemOffice> listItem = new ArrayList<>();
        listItem.add(new ItemOffice("Microsoft Word", "Traitement de texte Microsoft", R.drawable.ic_word));
        listItem.add(new ItemOffice("Microsoft Excel", "Tableur Microsoft", R.drawable.ic_excel));
        listItem.add(new ItemOffice("Microsoft PowerPoint", "Présentation Microsoft", R.drawable.ic_powerpoint));
        listItem.add(new ItemOffice("Microsoft Outlook", "Client mail Microsoft", R.drawable.ic_outlook));
        CustomAdapter adapter = new CustomAdapter(this, listItem);
        maListViewPerso.setAdapter(adapter);
        maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemOffice item = listItem.get(position);
                AlertDialog.Builder adb = new AlertDialog.Builder(ListViewPersoActivity.this);
                adb.setTitle("Sélection Application");
                adb.setMessage("Vous avez sélectionné : " + item.titre);
                adb.setPositiveButton("OK", null);
                adb.show();
            }
        });
    }
    class ItemOffice {
        String titre;
        String description;
        int img;
        ItemOffice(String titre, String description, int img) {
            this.titre = titre;
            this.description = description;
            this.img = img;
        }
    }
    class CustomAdapter extends BaseAdapter {
        Context context;
        ArrayList<ItemOffice> data;
        LayoutInflater inflater;

        CustomAdapter(Context context, ArrayList<ItemOffice> data) {
            this.context = context;
            this.data = data;
            this.inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return data.size();
        }
        @Override
        public Object getItem(int position) {
            return data.get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.affichageitem, parent, false);
            }
            ImageView img = convertView.findViewById(R.id.img);
            TextView titre = convertView.findViewById(R.id.titre);
            TextView description = convertView.findViewById(R.id.description);
            ItemOffice item = data.get(position);
            img.setImageResource(item.img);
            titre.setText(item.titre);
            description.setText(item.description);
            return convertView;
        }
    }
}