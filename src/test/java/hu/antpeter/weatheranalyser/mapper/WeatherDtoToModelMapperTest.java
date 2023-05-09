package hu.antpeter.weatheranalyser.mapper;

import hu.antpeter.weatheranalyser.controller.dto.*;
import hu.antpeter.weatheranalyser.service.model.Weather;
import hu.antpeter.weatheranalyser.service.model.WeatherData;
import hu.antpeter.weatheranalyser.service.model.WeatherLocation;
import hu.antpeter.weatheranalyser.service.model.WindDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDtoToModelMapperTest {

    @Test
    void givenLocationDtoShouldBeConvertedToWeatherLocation() {
        //Given
        WeatherDtoToModelMapper underTest = new WeatherDtoToModelMapper();
        LocationDto input = new LocationDto();
        input.setLatitude(18);
        input.setLongitude(10);
        WeatherLocation expectedResult = new WeatherLocation(10,18);

        //When
        WeatherLocation result = underTest.convertDtoToModel(input);

        //Then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void givenWeatherDataDtoShouldBeConvertedToWeatherData() {
        //Given
        WeatherDtoToModelMapper underTest = new WeatherDtoToModelMapper();

        LocationDto locationDto = new LocationDto();
        locationDto.setLatitude(18);
        locationDto.setLongitude(10);

        WeatherLocation weatherLocation = new WeatherLocation(10,18);

        WeatherDataDto input = new WeatherDataDto();
        input.setHumidity(20);
        input.setPressure(1);
        input.setTemperature(2);
        input.setWindDirection("NORTH");
        input.setWindSpeed(60);
        input.setLocation(locationDto);

        WeatherData expectedResult = new WeatherData(null, 2, 20, 1, 60, WindDirection.NORTH, weatherLocation);

        //When
        WeatherData result = underTest.convertDtoToModel(input);

        //Then
        Assertions.assertEquals(expectedResult, result);

    }

    @Test
    void givenTimestampDtoShouldBeConvertedToInstant() {
        //Given
        WeatherDtoToModelMapper underTest = new WeatherDtoToModelMapper();

        TimestampDto input = new TimestampDto();
        input.setHour(10);
        input.setDay(30);
        input.setMonth(4);
        input.setYear(2023);

        Instant expectedResult = Instant.parse("2023-04-30T10:00:00.00Z");

        //When
        Instant result = underTest.parseTimestamp(input);

        //Then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void givenWeatherInputDtoShouldBeConvertedToWeather() {
        //Given
        WeatherDtoToModelMapper underTest = new WeatherDtoToModelMapper();

        //Constructing WeatherInputDto
        LocationDto locationDto = new LocationDto();
        locationDto.setLatitude(18);
        locationDto.setLongitude(10);

        WeatherDataDto weatherDataDto = new WeatherDataDto();
        weatherDataDto.setHumidity(20);
        weatherDataDto.setPressure(1);
        weatherDataDto.setTemperature(2);
        weatherDataDto.setWindDirection("NORTH");
        weatherDataDto.setWindSpeed(60);
        weatherDataDto.setLocation(locationDto);

        TimestampDto timestampDto = new TimestampDto();
        timestampDto.setHour(10);
        timestampDto.setDay(30);
        timestampDto.setMonth(4);
        timestampDto.setYear(2023);

        MeasurementDto measurement = new MeasurementDto();
        measurement.setTimestamp(timestampDto);
        measurement.setId(1);
        measurement.setData(List.of(weatherDataDto));

        WeatherInputDto input = new WeatherInputDto();
        input.setMeasurement(measurement);

        //Constructing Weather expected output
        Weather expectedResult = new Weather();
        expectedResult.setId(1);
        expectedResult.setTimestamp(Instant.parse("2023-04-30T10:00:00.00Z"));
        expectedResult.setWeatherData(List.of(new WeatherData(null, 2, 20, 1, 60, WindDirection.NORTH, new WeatherLocation(10,18))));

        //When
        Weather result = underTest.convertDtoToModel(input);

        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}