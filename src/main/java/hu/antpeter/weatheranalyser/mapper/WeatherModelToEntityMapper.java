package hu.antpeter.weatheranalyser.mapper;

import hu.antpeter.weatheranalyser.repository.entity.WeatherMeasurementEntity;
import hu.antpeter.weatheranalyser.repository.entity.WeatherMetaDataEntity;
import hu.antpeter.weatheranalyser.service.model.Weather;
import hu.antpeter.weatheranalyser.service.model.WeatherData;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherModelToEntityMapper {
    public WeatherMetaDataEntity convert(Weather weather) {
        WeatherMetaDataEntity weatherMetaDataEntity = new WeatherMetaDataEntity();
        weatherMetaDataEntity.setMetadataId(weather.getId());
        weatherMetaDataEntity.setMeasurements(this.convert(weather.getWeatherData()));
        weatherMetaDataEntity.setTimestamp(weather.getTimestamp());
        // A kétirányú kapcsolatot be kell állítani. Eddig a pontig az egy több kapcsolat lett beállítva. Most pedig a több egy oldalt is be kell állítani.
        for (WeatherMeasurementEntity i : weatherMetaDataEntity.getMeasurements()) {
            i.setWeatherMetaData(weatherMetaDataEntity);
        }
        return weatherMetaDataEntity;
    }

    private List<WeatherMeasurementEntity> convert(List<WeatherData> weatherData) {
        return weatherData.stream()
                .map(weatherData1 -> this.convert(weatherData1))
                .collect(Collectors.toList());
    }

    private WeatherMeasurementEntity convert(WeatherData weatherData) {
        WeatherMeasurementEntity weatherMeasurementEntity = new WeatherMeasurementEntity();
        weatherMeasurementEntity.setMeasurementId(weatherData.getId());
        weatherMeasurementEntity.setHumidity(weatherData.getHumidity());
        weatherMeasurementEntity.setPressure(weatherData.getPressure());
        weatherMeasurementEntity.setTemperature(weatherData.getTemperature());
        weatherMeasurementEntity.setWindDirection(weatherData.getWindDirection());
        weatherMeasurementEntity.setLocationLatitude(weatherData.getWeatherLocation().getLatitude());
        weatherMeasurementEntity.setLocationLongitude(weatherData.getWeatherLocation().getLongitude());
        weatherMeasurementEntity.setWindSpeed(weatherData.getWindSpeed());
        return weatherMeasurementEntity;
    }
}
