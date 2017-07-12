package com.example.shoaibsilat.weatherapp;

/**
 * Created by Shoaib Silat on 7/6/2017.
 */

public class WeatherUpdate {

   public  Location location;
    public CurrentWeather currentWeather;
    public CurrentTemperature currentTemperature;
    public Wind wind;
    public Clouds clouds;

    public WeatherUpdate() {
        this.location = new Location();
        this.currentWeather = new CurrentWeather();
        this.currentTemperature = new CurrentTemperature();
        this.wind = new Wind();
        this.clouds =new Clouds();
    }

    public class Location{
        private double longitude;
        private double latitude;
        private String cityName;
        private String countryName;

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public String getCityName() {
            return cityName;
        }

        public String getCountryName() {
            return countryName;
        }
    }
    public class CurrentWeather{
        private int id;
        private String condition;
        private String description;
        private String iconId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIconId() {
            return iconId;
        }

        public void setIconId(String iconId) {
            this.iconId = iconId;
        }
    }
    public class CurrentTemperature{
        private double temp;
        private int pressure;
        private int humidity;
        private double tempMin;
        private double tempMax;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public double getTempMin() {
            return tempMin;
        }

        public void setTempMin(double tempMin) {
            this.tempMin = tempMin;
        }

        public double getTempMax() {
            return tempMax;
        }

        public void setTempMax(double tempMax) {
            this.tempMax = tempMax;
        }
    }
    public class Wind{
        private double speed;
        private int degree;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public int getDegree() {
            return degree;
        }

        public void setDegree(int degree) {
            this.degree = degree;
        }
    }
    public class Clouds{
        private int all;

        public int getAll() {
            return all;
        }

        public void setAll(int all) {
            this.all = all;
        }
    }
}
