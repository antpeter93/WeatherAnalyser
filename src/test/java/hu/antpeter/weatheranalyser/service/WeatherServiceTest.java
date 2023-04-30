package hu.antpeter.weatheranalyser.service;

import hu.antpeter.weatheranalyser.mapper.WeatherEntityToModelMapper;
import hu.antpeter.weatheranalyser.mapper.WeatherModelToEntityMapper;
import hu.antpeter.weatheranalyser.repository.WeatherMetadataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {
    @Mock
    private WeatherModelToEntityMapper modelToEntityMapper;
    @Mock
    private WeatherMetadataRepository metadataRepository;
    @Mock
    private WeatherEntityToModelMapper entityToModelMapper;
    private WeatherService underTest;

    @BeforeEach
    void init() {
        underTest = new WeatherService(modelToEntityMapper, metadataRepository, entityToModelMapper);
    }

    @Test
    void givenWeatherMustBeSentToDataBase() { //TODO
        //Given

        //When

        //Then
    }
}