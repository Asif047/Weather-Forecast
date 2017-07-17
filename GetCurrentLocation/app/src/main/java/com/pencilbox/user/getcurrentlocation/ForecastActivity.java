package com.pencilbox.user.getcurrentlocation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ForecastActivity extends AppCompatActivity {

    ListView weatherLV;
    private WeatherAdapter weatherAdapter;

    List<WeatherReport> temp = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        weatherLV= (ListView) findViewById(R.id.weatherListView);


        List<WeatherForecastResponse.ForecastList> forecast = MainActivity.forecastLists;

        Log.e("TAG", "forcast size" + forecast.size());



       for(int i=0;i<forecast.size();i++)
       {
           Log.e("Forcast:"+ i, forecast.get(i).toString());

           WeatherReport weatherReport = new WeatherReport(forecast.get(i).getTemp().getDay(),forecast.get(i).getTemp().getMorn(),forecast.get(i).getTemp().getNight(),forecast.get(i).getDt());
           temp.add(weatherReport);
       }


        weatherAdapter=new WeatherAdapter(this,temp);
        weatherLV.setAdapter(weatherAdapter);


    }
}
