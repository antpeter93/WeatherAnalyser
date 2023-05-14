package hu.antpeter.weatheranalyser.mapper;

import hu.antpeter.weatheranalyser.controller.dto.LocationDto;
import hu.antpeter.weatheranalyser.controller.dto.WeatherInputDto;
import hu.antpeter.weatheranalyser.service.model.Weather;
import hu.antpeter.weatheranalyser.service.model.WeatherLocation;
import org.springframework.stereotype.Component;

@Component
public class WeatherModelToDtoMapper {

    private LocationDto convert(WeatherLocation weatherLocation) {
        LocationDto locationDto = new LocationDto();
        locationDto.setLatitude(weatherLocation.getLatitude());
        locationDto.setLongitude(weatherLocation.getLongitude());
        return locationDto;
    }

    public WeatherInputDto convert(Weather weather) {
        WeatherInputDto weatherInputDto = new WeatherInputDto();
        //TODO Set all that object
        return weatherInputDto;
    }
}
