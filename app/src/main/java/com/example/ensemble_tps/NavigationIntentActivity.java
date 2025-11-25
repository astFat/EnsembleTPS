package com.example.ensemble_tps;

import android.content.Context;
import android.content.Intent;
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

public class NavigationIntentActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<ItemOffice> listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_intent);
        listView = findViewById(R.id.listviewnavigation);
        listItem = new ArrayList<>();
        listItem.add(new ItemOffice("Word", "Utilisez-vous Word ?", R.drawable.ic_word));
        listItem.add(new ItemOffice("Excel", "Utilisez-vous Excel ?", R.drawable.ic_excel));
        listItem.add(new ItemOffice("PowerPoint", "Utilisez-vous PowerPoint ?", R.drawable.ic_powerpoint));
        listItem.add(new ItemOffice("Outlook", "Utilisez-vous Outlook ?", R.drawable.ic_outlook));
        CustomAdapter adapter = new CustomAdapter(this, listItem);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemOffice item = listItem.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("titre", item.titre);
                bundle.putString("description", item.description);
                bundle.putInt("position", position);
                Intent intent = new Intent(NavigationIntentActivity.this, QuestionActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Votre Réponse");
            adb.setPositiveButton("Ok", null);
            switch (resultCode) {
                case 1: adb.setMessage("Vous utilisez Word."); break;
                case 2: adb.setMessage("Vous utilisez Excel."); break;
                case 3: adb.setMessage("Vous utilisez PowerPoint."); break;
                case 4: adb.setMessage("Vous utilisez Outlook."); break;
                case 5: adb.setMessage("Vous n'utilisez pas Word."); break;
                case 6: adb.setMessage("Vous n'utilisez pas Excel."); break;
                case 7: adb.setMessage("Vous n'utilisez pas PowerPoint."); break;
                case 8: adb.setMessage("Vous n'utilisez pas Outlook."); break;
            }
            adb.show();
        }
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