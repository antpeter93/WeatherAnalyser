package hu.antpeter.weatheranalyser.service;

import hu.antpeter.weatheranalyser.mapper.WeatherEntityToModelMapper;
import hu.antpeter.weatheranalyser.mapper.WeatherModelToEntityMapper;
import hu.antpeter.weatheranalyser.repository.WeatherMetadataRepository;
import hu.antpeter.weatheranalyser.repository.entity.WeatherMetaDataEntity;
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

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {
    private WeatherModelToEntityMapper modelToEntityMapper;
    @Mock
    private WeatherMetadataRepository metadataRepository;

    private WeatherEntityToModelMapper entityToModelMapper;
    private WeatherService underTest;

    @BeforeEach
    void init() {
        modelToEntityMapper = new WeatherModelToEntityMapper();
        entityToModelMapper = new WeatherEntityToModelMapper();
        underTest = new WeatherService(modelToEntityMapper, metadataRepository, entityToModelMapper);
    }

    @Test
    void givenWeatherMustBeSentToDataBase() {
        //Given
        WeatherMetaDataEntity entityComeFromRepository = new WeatherMetaDataEntity();
        entityComeFromRepository.setTimestamp(Instant.parse("2023-04-30T10:00:00.00Z"));
        entityComeFromRepository.setMetadataId(200);
        entityComeFromRepository.setMeasurements(List.of());

        Mockito.when(metadataRepository.save(Mockito.any(WeatherMetaDataEntity.class))).thenReturn(entityComeFromRepository);

        Weather weather = new Weather();
        weather.setTimestamp(Instant.parse("2023-04-30T10:00:00.00Z"));
        weather.setWeatherData(List.of());

        //When
        Weather result = underTest.storeWeather(weather);

        //Then
        Assertions.assertEquals(200, result.getId());
        Assertions.assertEquals(Instant.parse("2023-04-30T10:00:00.00Z"), result.getTimestamp());
        Mockito.verify(metadataRepository).save(Mockito.any(WeatherMetaDataEntity.class));
    }
}