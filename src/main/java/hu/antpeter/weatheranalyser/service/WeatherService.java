package hu.antpeter.weatheranalyser.service;

import hu.antpeter.weatheranalyser.controller.WeatherRestController;
import hu.antpeter.weatheranalyser.service.model.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private Logger logger = LoggerFactory.getLogger(WeatherRestController.class);

    public Weather storeWeather(Weather weather) {
        logger.info("Weather service received {}", weather);
        return null;
    }

}
