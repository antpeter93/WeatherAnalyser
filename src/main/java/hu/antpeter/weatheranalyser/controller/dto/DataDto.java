package hu.antpeter.weatheranalyser.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class DataDto {
    private double temperature;
    private double humidity;
    private double pressure;
    @JsonProperty(value = "wind_speed")
    private int windSpeed;
    @JsonProperty(value = "wind_direction")
    private String windDirection;
    private LocationDto location;

    public DataDto() {
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
        DataDto dataDto = (DataDto) o;
        return Double.compare(dataDto.temperature, temperature) == 0 && Double.compare(dataDto.humidity, humidity) == 0 && Double.compare(dataDto.pressure, pressure) == 0 && windSpeed == dataDto.windSpeed && Objects.equals(windDirection, dataDto.windDirection) && Objects.equals(location, dataDto.location);
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
