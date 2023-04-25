package hu.antpeter.weatheranalyser.service.model;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class Weather {
    private Integer id;
    private Instant timestamp;
    private List<WeatherData> weatherData;

    public Weather(Integer id, Instant timestamp, List<WeatherData> weatherData) {
        this.id = id;
        this.timestamp = timestamp;
        this.weatherData = weatherData;
    }

    public Weather() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public List<WeatherData> getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(List<WeatherData> weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Objects.equals(id, weather.id) && Objects.equals(timestamp, weather.timestamp) && Objects.equals(weatherData, weather.weatherData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, weatherData);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", weatherData=" + weatherData +
                '}';
    }
}
