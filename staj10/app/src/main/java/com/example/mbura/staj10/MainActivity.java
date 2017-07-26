package com.example.mbura.staj10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnCheckChanged {

    private Object List;
    String [] iller={"istanbul","ankara","izmir","sivas","antalya"};
    String [] Bolge={"marmara","ic anadolu","ege","ic anadolu","akdeniz"};
    String [] Plaka={"34","06","35","58","07"};
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView yourListView = (ListView) findViewById(R.id.itemListView);

        ArrayList<CitiyProperties> list = new ArrayList<>();

        for(int i = 0; i<5;i++){

            generateDummyData(list ,iller[i],Bolge[i],Plaka[i]);
        }


// get data from the table by the ListAdapter
        ListAdapter customAdapter = new ListAdapter(this, list, this);

        yourListView.setAdapter(customAdapter);

        ;



    }

    private void generateDummyData(ArrayList<CitiyProperties> list, String cityName, String cityArea, String cityPlaka){

        CitiyProperties cities = new CitiyProperties();

        cities.setCityName(cityName);
        cities.setArea(cityArea);
        cities.setCityPlaka(cityPlaka);
        list.add(cities);

    }


    @Override
    public void onCheckChanged(CitiyProperties citiyProperties) {

        txt.setText(citiyProperties.getCityName());
    }
}
