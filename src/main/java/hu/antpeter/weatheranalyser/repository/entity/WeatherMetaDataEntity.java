package hu.antpeter.weatheranalyser.repository.entity;

import hu.antpeter.weatheranalyser.service.model.WeatherData;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "METADATA")
public class WeatherMetaDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer metadataId;
    private Instant timestamp;
    @OneToMany(mappedBy = "weatherMetaData", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<WeatherMeasurementEntity> measurements;

    public WeatherMetaDataEntity() {
    }

    public WeatherMetaDataEntity(Integer metadataId, Instant timestamp, List<WeatherMeasurementEntity> measurements) {
        this.metadataId = metadataId;
        this.timestamp = timestamp;
        this.measurements = measurements;
    }

    public Integer getMetadataId() {
        return metadataId;
    }

    public void setMetadataId(Integer metadataId) {
        this.metadataId = metadataId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public List<WeatherMeasurementEntity> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<WeatherMeasurementEntity> measurements) {
        this.measurements = measurements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherMetaDataEntity that = (WeatherMetaDataEntity) o;
        return Objects.equals(metadataId, that.metadataId) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadataId, timestamp);
    }

    @Override
    public String toString() {
        return "WeatherMetaDataEntity{" +
                "metadataId=" + metadataId +
                ", timestamp=" + timestamp +
                '}';
    }
}
