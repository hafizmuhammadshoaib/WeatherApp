package com.example.shoaibsilat.weatherapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Shoaib Silat on 7/6/2017.
 */

public class JSONParser {
    public static WeatherUpdate getWeatherUpdateData(String data)throws JSONException{
        WeatherUpdate weatherUpdate=new WeatherUpdate();
        JSONObject jsonObject=new JSONObject(data);
        JSONObject coordObject=jsonObject.getJSONObject("coord");
        weatherUpdate.location.setLongitude(coordObject.getDouble("lon"));
        weatherUpdate.location.setLatitude(coordObject.getDouble("lat"));
        weatherUpdate.location.setCityName(jsonObject.getString("name"));

        JSONObject sysObject=jsonObject.getJSONObject("sys");
        weatherUpdate.location.setCountryName(sysObject.getString("country"));

        JSONArray jsonArray=jsonObject.getJSONArray("weather");
        JSONObject JSONWeather=jsonArray.getJSONObject(0);
        weatherUpdate.currentWeather.setId(JSONWeather.getInt("id"));
        weatherUpdate.currentWeather.setCondition(JSONWeather.getString("main"));
        weatherUpdate.currentWeather.setDescription(JSONWeather.getString("description"));

        JSONObject JSONMain=jsonObject.getJSONObject("main");
        weatherUpdate.currentTemperature.setTemp(JSONMain.getDouble("temp"));
        weatherUpdate.currentTemperature.setPressure(JSONMain.getInt("pressure"));
        weatherUpdate.currentTemperature.setHumidity(JSONMain.getInt("humidity"));
        weatherUpdate.currentTemperature.setTempMax(JSONMain.getDouble("temp_max"));
        weatherUpdate.currentTemperature.setTempMin(JSONMain.getDouble("temp_min"));

        JSONObject JSONWind=jsonObject.getJSONObject("wind");
        weatherUpdate.wind.setSpeed(JSONWind.getDouble("speed"));
        weatherUpdate.wind.setDegree(JSONWind.getInt("deg"));

        JSONObject JSONClouds=jsonObject.getJSONObject("clouds");
        weatherUpdate.clouds.setAll(JSONClouds.getInt("all"));

        return weatherUpdate;
    }
}
