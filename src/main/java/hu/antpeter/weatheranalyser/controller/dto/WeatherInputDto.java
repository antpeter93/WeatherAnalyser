package hu.antpeter.weatheranalyser.controller.dto;

import java.util.Objects;

public class WeatherInputDto {
    private MeasurementDto measurement;

    public WeatherInputDto() {
    }

    public MeasurementDto getMeasurement() {
        return measurement;
    }

    public void setMeasurement(MeasurementDto measurement) {
        this.measurement = measurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherInputDto that = (WeatherInputDto) o;
        return Objects.equals(measurement, that.measurement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(measurement);
    }

    @Override
    public String toString() {
        return "WeatherInputDto{" +
                "measurement=" + measurement +
                '}';
    }
}
