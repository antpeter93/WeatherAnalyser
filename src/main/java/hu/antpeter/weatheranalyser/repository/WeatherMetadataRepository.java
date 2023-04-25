package hu.antpeter.weatheranalyser.repository;

import hu.antpeter.weatheranalyser.repository.entity.WeatherMetaDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherMetadataRepository extends JpaRepository<WeatherMetaDataEntity, Integer> {

}
