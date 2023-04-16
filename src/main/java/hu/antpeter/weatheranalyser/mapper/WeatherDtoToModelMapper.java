package hu.antpeter.weatheranalyser.mapper;

import hu.antpeter.weatheranalyser.controller.dto.LocationDto;
import hu.antpeter.weatheranalyser.controller.dto.TimestampDto;
import hu.antpeter.weatheranalyser.controller.dto.WeatherDataDto;
import hu.antpeter.weatheranalyser.controller.dto.WeatherInputDto;
import hu.antpeter.weatheranalyser.service.model.Weather;
import hu.antpeter.weatheranalyser.service.model.WeatherData;
import hu.antpeter.weatheranalyser.service.model.WeatherLocation;
import hu.antpeter.weatheranalyser.service.model.WindDirection;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.stream.Collectors;

@Component
public class WeatherDtoToModelMapper {
    public Weather convertDtoToModel(WeatherInputDto weatherInputDto) {
        Weather weather = new Weather();
        weather.setId(weatherInputDto.getMeasurement().getId());
        weather.setTimestamp(parseTimestamp(weatherInputDto.getMeasurement().getTimestamp()));
        weather.setWeatherData(weatherInputDto.getMeasurement().getData().stream().map(this::convertDtoToModel).collect(Collectors.toList()));
        return weather;
    }

    private Instant parseTimestamp(TimestampDto timestampDto) {
        String year = String.valueOf(timestampDto.getYear());
        String month = timestampDto.getMonth() < 10 ? "0"+ timestampDto.getMonth() : String.valueOf(timestampDto.getMonth());
        String day = timestampDto.getDay() < 10 ? "0"+ timestampDto.getDay() : String.valueOf(timestampDto.getDay());
        String hour = timestampDto.getHour() < 10 ? "0"+ timestampDto.getHour() : String.valueOf(timestampDto.getHour());
        return Instant.parse(String.format("%s-%s-%sT%s:00:00.00Z", year, month, day, hour));
    }

    private WeatherData convertDtoToModel(WeatherDataDto weatherDataDto) {
        WeatherData weatherData = new WeatherData();
        weatherData.setTemperature(weatherDataDto.getTemperature());
        weatherData.setHumidity(weatherDataDto.getHumidity());
        weatherData.setPressure(weatherDataDto.getPressure());
        weatherData.setWindDirection(WindDirection.valueOf(weatherDataDto.getWindDirection().toUpperCase()));
        weatherData.setWeatherLocation(convertDtoToModel(weatherDataDto.getLocation()));
        return weatherData;
    }

    private WeatherLocation convertDtoToModel(LocationDto locationDto) {
        WeatherLocation weatherLocation = new WeatherLocation();
        weatherLocation.setLatitude(locationDto.getLatitude());
        weatherLocation.setLongitude(locationDto.getLongitude());
        return weatherLocation;
    }
}
