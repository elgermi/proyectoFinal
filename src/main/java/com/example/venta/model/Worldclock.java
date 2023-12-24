package com.example.venta.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Worldclock {
    private String id;
    private String currentDateTime;
    private String utcOffset;
    private Boolean isDayLightSavingsTime;
    private String dayOfTheWeek;
    private String timeZoneName;
    private Long currentFileTime;
    private String ordinalDate;
    private String serviceResponse;

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public String getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    public Boolean getDayLightSavingsTime() {
        return isDayLightSavingsTime;
    }

    public void setDayLightSavingsTime(Boolean dayLightSavingsTime) {
        isDayLightSavingsTime = dayLightSavingsTime;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getTimeZoneName() {
        return timeZoneName;
    }

    public void setTimeZoneName(String timeZoneName) {
        this.timeZoneName = timeZoneName;
    }

    public Long getCurrentFileTime() {
        return currentFileTime;
    }

    public void setCurrentFileTime(Long currentFileTime) {
        this.currentFileTime = currentFileTime;
    }

    public String getOrdinalDate() {
        return ordinalDate;
    }

    public void setOrdinalDate(String ordinalDate) {
        this.ordinalDate = ordinalDate;
    }

    public String getServiceResponse() {
        return serviceResponse;
    }

    public void setServiceResponse(String serviceResponse) {
        this.serviceResponse = serviceResponse;
    }
}
