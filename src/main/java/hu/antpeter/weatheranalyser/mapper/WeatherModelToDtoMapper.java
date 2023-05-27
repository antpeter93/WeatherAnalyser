package hu.antpeter.weatheranalyser.mapper;

import hu.antpeter.weatheranalyser.controller.dto.*;
import hu.antpeter.weatheranalyser.service.model.Weather;
import hu.antpeter.weatheranalyser.service.model.WeatherData;
import hu.antpeter.weatheranalyser.service.model.WeatherLocation;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherModelToDtoMapper {

    private LocationDto convert(WeatherLocation weatherLocation) {
        LocationDto locationDto = new LocationDto();
        locationDto.setLatitude(weatherLocation.getLatitude());
        locationDto.setLongitude(weatherLocation.getLongitude());
        return locationDto;
    }

    private TimestampDto convert(Instant instant) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
        TimestampDto timestampDto = new TimestampDto();
        timestampDto.setYear(localDateTime.getYear());
        timestampDto.setMonth(localDateTime.getMonth().getValue());
        timestampDto.setDay(localDateTime.getDayOfMonth());
        return  timestampDto;
    }

    private MeasurementDto convert(List<WeatherData> weatherData, Integer id, Instant timestamp) {
        MeasurementDto measurementDto = new MeasurementDto();
        measurementDto.setId(id);
        measurementDto.setTimestamp(convert(timestamp));
        measurementDto.setData(weatherData.stream().map(wData -> convert(wData)).collect(Collectors.toList()));
        return measurementDto;
    }

    private WeatherDataDto convert(WeatherData weatherData) {
        return null;
    }

    public WeatherInputDto convert(Weather weather) {
        WeatherInputDto weatherInputDto = new WeatherInputDto();
        MeasurementDto measurementDto = convert(weather.getWeatherData(), weather.getId(), weather.getTimestamp());
        weatherInputDto.setMeasurement(measurementDto);
        return weatherInputDto;
    }

}
