package com.example.android.serachinginlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    String[] rank;
    String[] country;
    String[] population;
    ArrayList<WorldPopulation> arraylist = new ArrayList<WorldPopulation>();

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Generate sample data
            rank = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

            country = new String[] { "AsherBhai", "SaadBhai", "ShehryarBhai",
                    "A.RafayBro", "MuzzamilBro", "WaqarBhai", "AliBhai", "ShadabBhai",
                    "Affan", "Nabeel" };

            population = new String[] { "asher@gmail.com", "shehryar@gmail.com",
                    "ali@gmail.com", "saad@gmail.com", "shadab@gmail.com", "khan@gmail.com",
                    "pakwan@gmail.com", "masla@gmail.com", "national@gmail.com", "shan@gmail.com" };

            // Locate the ListView in listview_main.xml
            list = (ListView) findViewById(R.id.list);

            for (int i = 0; i < rank.length; i++)
            {
                WorldPopulation wp = new WorldPopulation(rank[i], country[i],
                        population[i]);
                // Binds all strings into an array
                arraylist.add(wp);
            }

            // Pass results to ListViewAdapter Class
            adapter = new ListViewAdapter(this, arraylist);

            // Binds the Adapter to the ListView
            list.setAdapter(adapter);

            // Locate the EditText in listview_main.xml
            editsearch = (EditText) findViewById(R.id.search);

            // Capture Text in EditText
            editsearch.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable arg0) {
                    // TODO Auto-generated method stub
                    String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                    adapter.filter(text);
                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1,
                                              int arg2, int arg3) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                    // TODO Auto-generated method stub
                }
            });
        }


    }