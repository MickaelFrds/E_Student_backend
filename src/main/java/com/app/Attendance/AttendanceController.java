package com.app.Attendance;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping
    public List<Attendance> getAttendances(){
       return this.attendanceService.getAttendances();
    }

    @GetMapping("/{id}")
    public Attendance getAttendance(@PathVariable Integer id){
        return this.attendanceService.getAttendanceById(id);
    }

    @PostMapping
    public void addAttendance(@RequestBody AttendanceRequest attendanceRequest){
        this.attendanceService.addAttendance(attendanceRequest);
    }

    @PostMapping("/all")
    public void addAttendances (@RequestBody List<AttendanceRequest> attendanceListRequest){
        this.attendanceService.addAttendances(attendanceListRequest);
    }
}
