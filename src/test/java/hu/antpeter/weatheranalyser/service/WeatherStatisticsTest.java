package hu.antpeter.weatheranalyser.service;

import hu.antpeter.weatheranalyser.service.model.Weather;
import hu.antpeter.weatheranalyser.service.model.WeatherData;
import hu.antpeter.weatheranalyser.service.model.WeatherLocation;
import hu.antpeter.weatheranalyser.service.model.WindDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class WeatherStatisticsTest {
    @Mock
    private WeatherService weatherService;

    private WeatherStatistics underTest;

    @BeforeEach
    void init() {
        underTest = new WeatherStatistics(weatherService);
    }

    @Test
    void shouldGetMinimumReturnDoubleMinValueWhenNoWeatherData() {
        //Given
        Mockito.when(weatherService.findByTimeRange(Mockito.any(), Mockito.any())).thenReturn(List.of());

        //When
        Map<WeatherLocation, Double> result = underTest.getMinimumTemperatureByLocationInTimeRange(Instant.MIN, Instant.MAX);

        //Then
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void shouldGetMinimumReturnCorrectMapWhenWeatherDataExist() {
        //Given
        Mockito.when(weatherService.findByTimeRange(Mockito.any(), Mockito.any())).thenReturn(List.of(
                constructWeather(10,3,100,100),
                constructWeather(9,19,50,50)
        ));

        //When
        Map<WeatherLocation, Double> result = underTest.getMinimumTemperatureByLocationInTimeRange(Instant.MIN, Instant.MAX);

        //Then
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(3,result.get(new WeatherLocation(100,100)));
        Assertions.assertEquals(9, result.get(new WeatherLocation(50, 50)));
    }

    private Weather constructWeather(double temperatureA, double temperatureB, double lon, double lat) {
        Weather weather = new Weather();
        weather.setTimestamp(Instant.parse("2023-04-30T10:00:00.00Z"));
        weather.setWeatherData(List.of(
                new WeatherData(null, temperatureA, 20, 1, 60, WindDirection.NORTH, new WeatherLocation(lon,lat)),
                new WeatherData(null, temperatureB, 20, 1, 60, WindDirection.NORTH, new WeatherLocation(lon,lat))
        ));

        return weather;
    }

}