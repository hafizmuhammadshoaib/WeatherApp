package com.example.shoaibsilat.weatherapp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Shoaib Silat on 7/6/2017.
 */

public class HTTPRequestClass {
    private static String CONNECTIONURL="http://api.openweathermap.org/data/2.5/weather?id=";
    private static String APIKEY="&appid=9d3f42a6329ab0afe70a2551a309f79b";

    public String getHTTPRequestedData(String locationId){
       HttpURLConnection connection=null;
        InputStream inputStream=null;

        try
        {
            URL url = new URL(CONNECTIONURL+locationId+APIKEY);
             connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String value=bufferedReader.readLine();


          return value;


        }catch (Exception e){
            e.printStackTrace();

        }
        finally {
            try { connection.disconnect(); } catch(Exception e) {}
        }
        return null;
    }
}
