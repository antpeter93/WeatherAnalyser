package hu.antpeter.weatheranalyser.controller.dto;

import hu.antpeter.weatheranalyser.service.model.WeatherLocation;
import hu.antpeter.weatheranalyser.service.model.WindDirection;

import java.time.Instant;
import java.util.Map;

public class StatisticsDto {
    private Instant from;
    private Instant to;
    private Map<WeatherLocation, Double> minimumTemperatureByLocationByTimeRange;
    private Map<WeatherLocation, Double> maximumTemperatureByLocationByTimeRange;
    private WindDirection mostFrequentWindDirectionThisYear;
    private Map<WeatherLocation, Double> averageWindSpeedByLocation;
    private Map<WeatherLocation, Boolean> averageHumidityOfLocationAboveAverageHumidity;

    public StatisticsDto() {
    }

    public Instant getFrom() {
        return from;
    }

    public void setFrom(Instant from) {
        this.from = from;
    }

    public Instant getTo() {
        return to;
    }

    public void setTo(Instant to) {
        this.to = to;
    }

    public Map<WeatherLocation, Double> getMinimumTemperatureByLocationByTimeRange() {
        return minimumTemperatureByLocationByTimeRange;
    }

    public void setMinimumTemperatureByLocationByTimeRange(Map<WeatherLocation, Double> minimumTemperatureByLocationByTimeRange) {
        this.minimumTemperatureByLocationByTimeRange = minimumTemperatureByLocationByTimeRange;
    }

    public Map<WeatherLocation, Double> getMaximumTemperatureByLocationByTimeRange() {
        return maximumTemperatureByLocationByTimeRange;
    }

    public void setMaximumTemperatureByLocationByTimeRange(Map<WeatherLocation, Double> maximumTemperatureByLocationByTimeRange) {
        this.maximumTemperatureByLocationByTimeRange = maximumTemperatureByLocationByTimeRange;
    }

    public WindDirection getMostFrequentWindDirectionThisYear() {
        return mostFrequentWindDirectionThisYear;
    }

    public void setMostFrequentWindDirectionThisYear(WindDirection mostFrequentWindDirectionThisYear) {
        this.mostFrequentWindDirectionThisYear = mostFrequentWindDirectionThisYear;
    }

    public Map<WeatherLocation, Double> getAverageWindSpeedByLocation() {
        return averageWindSpeedByLocation;
    }

    public void setAverageWindSpeedByLocation(Map<WeatherLocation, Double> averageWindSpeedByLocation) {
        this.averageWindSpeedByLocation = averageWindSpeedByLocation;
    }

    public Map<WeatherLocation, Boolean> getAverageHumidityOfLocationAboveAverageHumidity() {
        return averageHumidityOfLocationAboveAverageHumidity;
    }

    public void setAverageHumidityOfLocationAboveAverageHumidity(Map<WeatherLocation, Boolean> averageHumidityOfLocationAboveAverageHumidity) {
        this.averageHumidityOfLocationAboveAverageHumidity = averageHumidityOfLocationAboveAverageHumidity;
    }
}


