package hu.antpeter.weatheranalyser.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class WeatherDataDto {
    private double temperature;
    private double humidity;
    private double pressure;
    @JsonProperty(value = "wind_speed")
    private int windSpeed;
    @JsonProperty(value = "wind_direction")
    private String windDirection;
    private LocationDto location;

    public WeatherDataDto() {
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

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherDataDto weatherDataDto = (WeatherDataDto) o;
        return Double.compare(weatherDataDto.temperature, temperature) == 0 && Double.compare(weatherDataDto.humidity, humidity) == 0 && Double.compare(weatherDataDto.pressure, pressure) == 0 && windSpeed == weatherDataDto.windSpeed && Objects.equals(windDirection, weatherDataDto.windDirection) && Objects.equals(location, weatherDataDto.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature, humidity, pressure, windSpeed, windDirection, location);
    }

    @Override
    public String toString() {
        return "DataDto{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", windSpeed=" + windSpeed +
                ", windDirection='" + windDirection + '\'' +
                ", location=" + location +
                '}';
    }
}
