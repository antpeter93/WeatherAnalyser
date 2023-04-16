package hu.antpeter.weatheranalyser.controller;

import hu.antpeter.weatheranalyser.controller.dto.WeatherInputDto;
import hu.antpeter.weatheranalyser.mapper.WeatherDtoToModelMapper;
import hu.antpeter.weatheranalyser.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherRestController {

    private Logger logger = LoggerFactory.getLogger(WeatherRestController.class);

    private final WeatherService weatherService;
    private final WeatherDtoToModelMapper dtoToModelMapper;

    @Autowired
    public WeatherRestController(WeatherService weatherService, WeatherDtoToModelMapper dtoToModelMapper) {
        this.weatherService = weatherService;
        this.dtoToModelMapper = dtoToModelMapper;
    }

    @PostMapping
    public void saveWeatherData(@RequestBody WeatherInputDto weatherInput) {
        logger.info("Incoming data: {}", weatherInput);
        weatherService.storeWeather(dtoToModelMapper.convertDtoToModel(weatherInput));
    }
}
