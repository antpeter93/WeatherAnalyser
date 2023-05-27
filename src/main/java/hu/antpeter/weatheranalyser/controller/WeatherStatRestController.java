package hu.antpeter.weatheranalyser.controller;

import hu.antpeter.weatheranalyser.controller.dto.StatisticsDto;
import hu.antpeter.weatheranalyser.service.WeatherStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("statistics")
public class WeatherStatRestController {
    private final WeatherStatistics weatherStatistics;

    @Autowired
    public WeatherStatRestController(WeatherStatistics weatherStatistics) {
        this.weatherStatistics = weatherStatistics;
    }

    @GetMapping
    public ResponseEntity<StatisticsDto> getAllStatData(@RequestParam Instant from, @RequestParam Instant to) {
        StatisticsDto statisticsDto = new StatisticsDto();
        statisticsDto.setFrom(from);
        statisticsDto.setTo(to);
        statisticsDto.setAverageHumidityOfLocationAboveAverageHumidity(weatherStatistics.isAverageHumidityOfLocationAboveAverageHumidity());
        statisticsDto.setAverageWindSpeedByLocation(weatherStatistics.getAverageWindSpeedByLocation());
        statisticsDto.setMaximumTemperatureByLocationByTimeRange(weatherStatistics.getMaximumTemperatureByLocationInTimeRange(from, to));
        statisticsDto.setMinimumTemperatureByLocationByTimeRange(weatherStatistics.getMinimumTemperatureByLocationInTimeRange(from, to));
        statisticsDto.setMostFrequentWindDirectionThisYear(weatherStatistics.getMostFrequentWindDirectionThisYear());
        return ResponseEntity.ok(statisticsDto);
    }
}
