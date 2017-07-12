package com.example.shoaibsilat.weatherapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class WeatherActivity extends AppCompatActivity {
    TextView cityName,currTemp,decription,tempMax,tempMin,condition,humidiy;
    String read="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        cityName= (TextView) findViewById(R.id.city_name);
        currTemp= (TextView) findViewById(R.id.curr_temp);
       decription= (TextView) findViewById(R.id.descrip);
        tempMax= (TextView) findViewById(R.id.temp_max);
        tempMin= (TextView) findViewById(R.id.temp_min);
        condition= (TextView) findViewById(R.id.condition);
        humidiy= (TextView) findViewById(R.id.humidity);
        Intent intent=getIntent();
        String locId=String.valueOf(intent.getIntExtra("locationid",0));
        BackgroundWeatherTask backgroundWeatherTask=new BackgroundWeatherTask();
        backgroundWeatherTask.execute(new String[]{locId});
    }











    public class BackgroundWeatherTask extends AsyncTask<String,Void,WeatherUpdate>{
      String data="";
       @Override
        protected WeatherUpdate doInBackground(String... params) {
          WeatherUpdate weatherUpdate=new WeatherUpdate();
             data=((new HTTPRequestClass()).getHTTPRequestedData(params[0]));

//

            try
            {
              weatherUpdate=JSONParser.getWeatherUpdateData(data);

            }
            catch (JSONException e){
                e.printStackTrace();

            }
//

            return weatherUpdate;
        }

        @Override
        protected void onPostExecute(WeatherUpdate weatherUpdate) {
        //    super.onPostExecute(weatherUpdate);
            cityName.setText(weatherUpdate.location.getCityName()+","+weatherUpdate.location.getCountryName());
            currTemp.setText(Html.fromHtml("Current Temp: "+String.valueOf((new DecimalFormat("#0.0").format(weatherUpdate.currentTemperature.getTemp()-273.15)))+"&deg;C"));
            decription.setText(weatherUpdate.currentWeather.getDescription());
            tempMax.setText(Html.fromHtml("Max Temp: "+String.valueOf((new DecimalFormat("#0.0").format(weatherUpdate.currentTemperature.getTempMax()-273.15)))+"&deg;C"));
            tempMin.setText(Html.fromHtml("Min Temp: "+String.valueOf((new DecimalFormat("#0.0").format(weatherUpdate.currentTemperature.getTempMin()-273.15)))+"&deg;C"));
            condition.setText(weatherUpdate.currentWeather.getCondition());
            humidiy.setText("Humidity: "+String.valueOf(weatherUpdate.currentTemperature.getHumidity()));

        }
    }
}
