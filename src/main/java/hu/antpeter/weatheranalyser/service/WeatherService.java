package hu.antpeter.weatheranalyser.service;

import hu.antpeter.weatheranalyser.controller.WeatherRestController;
import hu.antpeter.weatheranalyser.mapper.WeatherEntityToModelMapper;
import hu.antpeter.weatheranalyser.mapper.WeatherModelToEntityMapper;
import hu.antpeter.weatheranalyser.repository.WeatherMetadataRepository;
import hu.antpeter.weatheranalyser.repository.entity.WeatherMetaDataEntity;
import hu.antpeter.weatheranalyser.service.model.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private Logger logger = LoggerFactory.getLogger(WeatherRestController.class);
    private final WeatherModelToEntityMapper modelToEntityMapper;
    private final WeatherMetadataRepository metadataRepository;
    private final WeatherEntityToModelMapper entityToModelMapper;
    @Autowired
    public WeatherService(WeatherModelToEntityMapper modelToEntityMapper, WeatherMetadataRepository metadataRepository, WeatherEntityToModelMapper entityToModelMapper) {
        this.modelToEntityMapper = modelToEntityMapper;
        this.metadataRepository = metadataRepository;
        this.entityToModelMapper = entityToModelMapper;
    }


    public Weather storeWeather(Weather weather) {
        logger.info("Weather service received {}", weather);
        WeatherMetaDataEntity entity = modelToEntityMapper.convert(weather);
        WeatherMetaDataEntity savedEntity = metadataRepository.save(entity);
        logger.info("Saved entity {}", savedEntity);
        return entityToModelMapper.convert(savedEntity);
    }

}
