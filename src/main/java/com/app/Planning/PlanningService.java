package com.app.Planning;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PlanningService {

    private final PlanningRepository planningRepository;

    public List<Planning> getAllPlannings (){
        return this.planningRepository.findAll();
    }

    public Planning getPlanningByTeacherID(Integer teacherId){
        List<Planning> plannings = getAllPlannings();
        return filterByTeacherId(plannings, teacherId);
    }

    public void addPlanning (PlanningRequest planningRequest) {
        Planning newPlanning = Planning.builder()
                .teacher(planningRequest.teacher())
                .timeSlots(planningRequest.timeSlots())
                .build();
        this.planningRepository.save(newPlanning);
    }

    private Planning filterByTeacherId(List<Planning> plannings, Integer teacherId) {
        Stream<Planning> stream =plannings.stream();
        Optional<Planning> result = stream
                .filter(planning -> Objects.equals(planning.getTeacher().getId(),teacherId))
                .findAny();
        return result.orElseThrow();
    }
}
