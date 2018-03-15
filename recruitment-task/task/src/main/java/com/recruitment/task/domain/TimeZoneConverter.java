package com.recruitment.task.domain;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneConverter {

    public ZonedDateTime adjustToTimeZone(ZonedDateTime dateTime, ZoneId requestedZoneTime) {
        return ZonedDateTime.of(dateTime.toLocalDateTime(), requestedZoneTime);
    }
}
