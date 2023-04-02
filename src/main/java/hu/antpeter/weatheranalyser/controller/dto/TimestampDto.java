package hu.antpeter.weatheranalyser.controller.dto;

import java.util.Objects;

public class TimestampDto {
    private int day;
    private int month;
    private int year;
    private int hour;

    public TimestampDto() {
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimestampDto that = (TimestampDto) o;
        return day == that.day && month == that.month && year == that.year && hour == that.hour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year, hour);
    }

    @Override
    public String toString() {
        return "TimestampDto{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", hour=" + hour +
                '}';
    }
}
