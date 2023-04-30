package hu.antpeter.weatheranalyser.mapper;

import hu.antpeter.weatheranalyser.repository.entity.WeatherMeasurementEntity;
import hu.antpeter.weatheranalyser.repository.entity.WeatherMetaDataEntity;
import hu.antpeter.weatheranalyser.service.model.Weather;
import hu.antpeter.weatheranalyser.service.model.WeatherData;
import hu.antpeter.weatheranalyser.service.model.WeatherLocation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherEntityToModelMapper {
    public Weather convert(WeatherMetaDataEntity entity) {
        Weather weather = new Weather();
        weather.setWeatherData(this.convert(entity.getMeasurements()));
        weather.setTimestamp(entity.getTimestamp());
        weather.setId(entity.getMetadataId());
        return weather;
    }

     List<WeatherData> convert(List<WeatherMeasurementEntity> measurementEntities) {
        return measurementEntities.stream()
                .map(data -> this.convert(data))
                .collect(Collectors.toList());
    }

    WeatherData convert(WeatherMeasurementEntity measurementEntity) {
        WeatherData weatherData = new WeatherData();
        weatherData.setWeatherLocation(new WeatherLocation(measurementEntity.getLocationLatitude(), measurementEntity.getLocationLongitude()));
        weatherData.setPressure(measurementEntity.getPressure());
        weatherData.setHumidity(measurementEntity.getHumidity());
        weatherData.setTemperature(measurementEntity.getTemperature());
        weatherData.setWindDirection(measurementEntity.getWindDirection());
        return weatherData;

    }
}
