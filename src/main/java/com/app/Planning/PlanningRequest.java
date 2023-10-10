package com.app.Planning;

import com.app.TimeSlot.TimeSlot;
import com.app.User.User;
import java.util.List;

public record PlanningRequest(
        User teacher,
        List<TimeSlot> timeSlots
) {
}
