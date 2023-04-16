package hu.antpeter.weatheranalyser.controller;

import hu.antpeter.weatheranalyser.controller.dto.WeatherInputDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherRestController {

    private Logger logger = LoggerFactory.getLogger(WeatherRestController.class);

    @PostMapping
    public void saveWeatherData(@RequestBody WeatherInputDto weatherInput) {
        logger.info("Incoming data: {}", weatherInput);
    }
}
