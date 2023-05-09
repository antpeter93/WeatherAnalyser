package hu.antpeter.weatheranalyser.service;

import hu.antpeter.weatheranalyser.repository.WeatherMetadataRepository;
import hu.antpeter.weatheranalyser.service.model.Weather;
import hu.antpeter.weatheranalyser.service.model.WeatherData;
import hu.antpeter.weatheranalyser.service.model.WeatherLocation;
import hu.antpeter.weatheranalyser.service.model.WindDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.List;

@SpringBootTest
class WeatherServiceIT {
	@Autowired
	private WeatherService underTest;
	@Autowired
	private WeatherMetadataRepository weatherMetadataRepository;

	@BeforeEach
	void cleanUp() {
		weatherMetadataRepository.deleteAll();
	}

	@Test
	void givenWeatherDataMustBeSavedDataBase() {
		//Given
		Weather weather = new Weather();
		weather.setTimestamp(Instant.parse("2023-04-30T10:00:00.00Z"));
		weather.setWeatherData(List.of(new WeatherData(null, 2, 20, 1, 60, WindDirection.NORTH, new WeatherLocation(10,18))));

		//When
		Weather result = underTest.storeWeather(weather);

		//Then
		Assertions.assertNotNull(result.getId());
	}

}
