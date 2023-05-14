package hu.antpeter.weatheranalyser.service;

import hu.antpeter.weatheranalyser.service.model.Weather;
import hu.antpeter.weatheranalyser.service.model.WeatherData;
import hu.antpeter.weatheranalyser.service.model.WeatherLocation;
import hu.antpeter.weatheranalyser.service.model.WindDirection;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
    Retrieving the minimum temperature value by location in a specific time range.
    Retrieving the maximum temperature value by location in a specific time range.
    Retrieving the most frequently occurred wind direction this year.
    Retrieving the average of wind speed by locations yearly.
    Retrieving the fact if humidity is above average or not.
     */

@Service
public class WeatherStatistics {
    private final WeatherService weatherService;

    public WeatherStatistics(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    //Map: Location -> minimum temperature
    public Map<WeatherLocation, Double> getMinimumTemperatureByLocationInTimeRange(Instant from, Instant to) {
        List<Weather> data = weatherService.findByTimeRange(from, to);
        Set<WeatherLocation> locations = getUniqueLocation(data);
        return locations.stream()
                .collect(Collectors.toMap(
                        location -> location,
                        location -> getMinimumTemperature(location, data)
                ));
    }

    private Set<WeatherLocation> getUniqueLocation(List<Weather> data) {
        return data.stream()
                .map(weather -> weather.getWeatherData())
                .flatMap(weatherData -> weatherData.stream())
                .map(weatherData -> weatherData.getWeatherLocation())
                .collect(Collectors.toSet());
    }

    private Double getMinimumTemperature(WeatherLocation location, List<Weather> data) {
        return getTemperature(location, data).stream()
                .mapToDouble(value -> value)
                .min()
                .orElse(Double.MIN_VALUE);
    }

    private Double getMaximumTemperature(WeatherLocation location, List<Weather> data) {
        return getTemperature(location, data).stream()
                .mapToDouble(value -> value)
                .max()
                .orElse(Double.MAX_VALUE);
    }

    private List<Double> getTemperature(WeatherLocation location, List<Weather> data) {
        return data.stream()
                .map(weather -> weather.getWeatherData())
                .flatMap(weatherDataList -> weatherDataList.stream())
                .filter(weatherData -> weatherData.getWeatherLocation().equals(location))
                .map(weatherData -> weatherData.getTemperature())
                .collect(Collectors.toList());
    }

    public Map<WeatherLocation, Double> getMaximumTemperatureByLocationInTimeRange(Instant from, Instant to) {
        List<Weather> data = weatherService.findByTimeRange(from, to);
        Set<WeatherLocation> locations = getUniqueLocation(data);
        return locations.stream()
                .collect(Collectors.toMap(
                        location -> location,
                        location -> getMaximumTemperature(location, data)
                ));
    }

    public WindDirection getMostFrequentWindDirectionThisYear() {
        Instant from =  Instant.parse(LocalDate.now().getYear() + "-01-01T00:00:00.00Z");
        List<Weather> data = weatherService.findByTimeRange(from, Instant.now());

        Map<WindDirection, Integer> numberOfWindDirections = getNumberOfWindDirections(data);

        return numberOfWindDirections.entrySet().stream()
                .sorted((entry1, entry2) -> entry1.getValue() - entry2.getValue())
                .map(entry -> entry.getKey())
                .findFirst()
                .orElse(null);
    }

    private Map<WindDirection, Integer> getNumberOfWindDirections(List<Weather> data) {
        return data.stream()
                .map(weather -> weather.getWeatherData())
                .flatMap(weatherDataList -> weatherDataList.stream())
                .map(weatherData -> weatherData.getWindDirection())
                .collect(Collectors.toMap(
                        direction -> direction,
                        direction -> 1,
                        (v1, v2) -> v1 + v2
                ));
    }

}
