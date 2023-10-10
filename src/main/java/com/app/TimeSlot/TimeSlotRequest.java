package com.app.TimeSlot;

import com.app.Course.Course;


public record TimeSlotRequest(
        Course course,
        String day,
        Integer startTimeHour,
        Integer startTimeMinute,
        Integer endTimeHour,
        Integer endTimeMinute
) {
}
