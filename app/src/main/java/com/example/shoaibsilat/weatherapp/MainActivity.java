package com.example.shoaibsilat.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView citiesList;
    String locationId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        citiesList=(ListView)findViewById(R.id.cities_list);
        ArrayAdapter arrayAdapter=ArrayAdapter.createFromResource(this,R.array.cityname,android.R.layout.simple_list_item_1);
        citiesList.setAdapter(arrayAdapter);

        citiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                 Intent intent=new Intent(MainActivity.this,WeatherActivity.class);
                    intent.putExtra("locationid",1174872);
                    startActivity(intent);
                }
                else if(position==1){
                    Intent intent =new Intent(MainActivity.this,WeatherActivity.class);
                    intent.putExtra("locationid",1172451);
                    startActivity(intent);
                }
                else if(position==2){
                    Intent intent =new Intent(MainActivity.this,WeatherActivity.class);
                    intent.putExtra("locationid",1176615);
                    startActivity(intent);
                }
            }
        });
    }
}
