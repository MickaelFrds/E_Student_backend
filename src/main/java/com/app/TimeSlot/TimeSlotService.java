package com.app.TimeSlot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;


    public  List<TimeSlot> getTimeSlots (){
        return timeSlotRepository.findAll();
    }

    public List<TimeSlot> getTimeSlotsByCourse (Integer courseId){
        List<TimeSlot> timeSlots = getTimeSlots();
        Stream<TimeSlot> stream = timeSlots
                .stream()
                .filter(timeSlot -> timeSlot.getCourse().getId().equals(courseId));
        return stream.toList();
    }

    public void addTimeSlot(TimeSlotRequest timeSlotRequest) {
        TimeSlot newTimeSlot = TimeSlot.builder()
                .course(timeSlotRequest.course())
                .day(DayOfWeek.valueOf(timeSlotRequest.day()))
                .startTime(LocalTime.of(timeSlotRequest.startTimeHour(),timeSlotRequest.startTimeMinute()))
                .endTime(LocalTime.of(timeSlotRequest.endTimeHour(),timeSlotRequest.startTimeMinute()))
        .build();
        timeSlotRepository.save(newTimeSlot);
    }
}
