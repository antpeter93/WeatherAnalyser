package hu.antpeter.weatheranalyser.controller.dto;

import java.util.List;
import java.util.Objects;

public class MeasurementDto {
    private Integer id;
    private TimestampDto timestamp;
    private List<DataDto> data;

    public MeasurementDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TimestampDto getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(TimestampDto timestamp) {
        this.timestamp = timestamp;
    }

    public List<DataDto> getData() {
        return data;
    }

    public void setData(List<DataDto> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeasurementDto that = (MeasurementDto) o;
        return Objects.equals(id, that.id) && Objects.equals(timestamp, that.timestamp) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, data);
    }

    @Override
    public String toString() {
        return "MeasurementDto{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }
}
