package hu.antpeter.weatheranalyser.repository;

import hu.antpeter.weatheranalyser.repository.entity.WeatherMetaDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface WeatherMetadataRepository extends JpaRepository<WeatherMetaDataEntity, Integer> {
    @Query("select w from WeatherMetaDataEntity w where w.timestamp between :from and :to")
    List<WeatherMetaDataEntity> findByTimeRange(@Param("from") Instant from, @Param("to") Instant to);
}


