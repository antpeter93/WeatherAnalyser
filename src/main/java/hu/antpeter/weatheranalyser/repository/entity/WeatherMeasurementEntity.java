package hu.antpeter.weatheranalyser.repository.entity;

import hu.antpeter.weatheranalyser.service.model.WeatherLocation;
import hu.antpeter.weatheranalyser.service.model.WindDirection;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MEASUREMENTS")
public class WeatherMeasurementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer measurementId;
    private double temperature;
    private double humidity;
    private double pressure;
    private int windSpeed;
    @Enumerated(EnumType.STRING)
    private WindDirection windDirection;
    private double locationLongitude;
    private double locationLatitude;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "metadata_id") // A JoinColumnban mindig a valódi elnevezeését kell használni az idegen kulcsokat tartalmazó oszlopnak.
    private WeatherMetaDataEntity weatherMetaData; //Ez direkt nincs benne az equalsben a hsahCodeban és a toStringben.

    public WeatherMeasurementEntity() {
    }

    public WeatherMeasurementEntity(Integer measurementId, double temperature, double humidity, double pressure, int windSpeed, WindDirection windDirection, double locationLongitude, double locationLatitude) {
        this.measurementId = measurementId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.locationLongitude = locationLongitude;
        this.locationLatitude = locationLatitude;
    }

    public Integer getMeasurementId() {
        return measurementId;
    }

    public WeatherMetaDataEntity getWeatherMetaData() {
        return weatherMetaData;
    }

    public void setWeatherMetaData(WeatherMetaDataEntity weatherMetaData) {
        this.weatherMetaData = weatherMetaData;
    }

    public void setMeasurementId(Integer measurementId) {
        this.measurementId = measurementId;
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

    public double getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(double locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public double getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(double locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherMeasurementEntity that = (WeatherMeasurementEntity) o;
        return Double.compare(that.temperature, temperature) == 0 && Double.compare(that.humidity, humidity) == 0 && Double.compare(that.pressure, pressure) == 0 && windSpeed == that.windSpeed && Double.compare(that.locationLongitude, locationLongitude) == 0 && Double.compare(that.locationLatitude, locationLatitude) == 0 && Objects.equals(measurementId, that.measurementId) && windDirection == that.windDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(measurementId, temperature, humidity, pressure, windSpeed, windDirection, locationLongitude, locationLatitude);
    }

    @Override
    public String toString() {
        return "WeatherMeasurementEntity{" +
                "measurementId=" + measurementId +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", locationLongitude=" + locationLongitude +
                ", locationLatitude=" + locationLatitude +
                '}';
    }
}
