package com.app.Planning;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/planning")
@RequiredArgsConstructor
public class PlanningController {

    private final PlanningService planningService;

    @GetMapping
    public List<Planning> getPlannings () {
        return this.planningService.getAllPlannings();
    }

    @GetMapping("/teacher/{id}")
    public Planning getPlanningByTeacherId (@PathVariable(name = "id") Integer teacherId) {
        return this.planningService.getPlanningByTeacherID(teacherId);
    }

    @PostMapping
    public void addPlanning (PlanningRequest planningRequest) {
        this.planningService.addPlanning(planningRequest);
    }

}
