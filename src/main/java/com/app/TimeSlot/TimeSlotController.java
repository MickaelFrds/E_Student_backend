package com.app.TimeSlot;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/timeSlot")
public class TimeSlotController {

    private final TimeSlotService timeSlotService;

    @GetMapping
    public List<TimeSlot> getTimeSlots(){
        return timeSlotService.getTimeSlots();
    }

    @GetMapping("/course/{id}")
    public List<TimeSlot> getTimeSlotsByCourse(@PathVariable(name = "id") Integer courseId){
        return timeSlotService.getTimeSlotsByCourse(courseId);
    }

    @PostMapping
    public void addTimeSlot (TimeSlotRequest timeSlotRequest){
        timeSlotService.addTimeSlot(timeSlotRequest);
    }
}
