package hu.antpeter.weatheranalyser.service.model;

import java.util.Objects;

public class WeatherData {

    private Integer id;
    private double temperature;
    private double humidity;
    private double pressure;
    private int windSpeed;
    private WindDirection windDirection;
    private WeatherLocation weatherLocation;

    public WeatherData() {
    }

    public WeatherData(Integer id, double temperature, double humidity, double pressure, int windSpeed, WindDirection windDirection, WeatherLocation weatherLocation) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.weatherLocation = weatherLocation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    public WeatherLocation getWeatherLocation() {
        return weatherLocation;
    }

    public void setWeatherLocation(WeatherLocation weatherLocation) {
        this.weatherLocation = weatherLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherData that = (WeatherData) o;
        return Double.compare(that.temperature, temperature) == 0 && Double.compare(that.humidity, humidity) == 0 && Double.compare(that.pressure, pressure) == 0 && windSpeed == that.windSpeed && Objects.equals(id, that.id) && windDirection == that.windDirection && Objects.equals(weatherLocation, that.weatherLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, temperature, humidity, pressure, windSpeed, windDirection, weatherLocation);
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", weatherLocation=" + weatherLocation +
                '}';
    }
}
