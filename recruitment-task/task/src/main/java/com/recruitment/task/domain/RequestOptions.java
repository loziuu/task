package com.recruitment.task.domain;

import java.time.ZoneId;

public class RequestOptions {

    private final ZoneId timeZone;

    public RequestOptions(String requestedTimeZone) {
        this.timeZone = resolveTimeZone(requestedTimeZone);
    }

    private ZoneId resolveTimeZone(String requestedTimeZone) {
        ZoneId timeZone = null;
        if (requestedTimeZone != null) {
            timeZone = ZoneId.of(requestedTimeZone);
        }
        return timeZone;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }
}
