package com.recruitment.task.domain;

import org.junit.Before;
import org.junit.Test;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRulesException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TimeZoneConverterTest {

    private TimeZoneConverter timeZoneConverter;

    @Before
    public void setup() {
        timeZoneConverter = new TimeZoneConverter();
    }

    @Test
    public void adjustToValidTimeZone() {
        ZoneId requestedZoneTime = ZoneId.of("CET");
        ZonedDateTime dateTime = ZonedDateTime.now();

        ZonedDateTime adaptedZoneTime = timeZoneConverter.adjustToTimeZone(dateTime, requestedZoneTime);

        assertNotEquals(dateTime, adaptedZoneTime);
        assertEquals(adaptedZoneTime.getZone(), requestedZoneTime);
    }

    @Test(expected = ZoneRulesException.class)
    public void adjutToNonExistentTimeZone() {
        ZoneId requestedZoneTime = ZoneId.of("TimeZone/NotFound");
        ZonedDateTime dateTime = ZonedDateTime.now();

        timeZoneConverter.adjustToTimeZone(dateTime, requestedZoneTime);
    }
}
