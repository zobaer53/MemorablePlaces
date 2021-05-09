package com.example.zobaer53.memorableplaces;

import android.content.Intent;


import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> places = new ArrayList<>();
    static ArrayList<LatLng> locations = new ArrayList<>();
    static ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        places.add("Add a new place...");
        locations.add(new LatLng(0,0));

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, places);

        listView.setAdapter(arrayAdapter);



        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
            intent.putExtra("placeNumber",i);

            startActivity(intent);






        });
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            places.remove(position);

            arrayAdapter.notifyDataSetChanged();

            Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_LONG).show();

            return true;
        });

    }
}
