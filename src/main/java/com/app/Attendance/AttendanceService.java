package com.app.Attendance;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getAttendances() {
        return this.attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Integer id){
        return this.attendanceRepository.findById(id).orElse(null);
    }

    public void addAttendance(AttendanceRequest attendanceRequest) {
        Attendance attendance = new Attendance();
        attendance.setDate(attendanceRequest.date());
        attendance.setStatus(attendanceRequest.status());
        attendance.setStudent(attendanceRequest.student());
        this.attendanceRepository.save(attendance);
    }

    public void addAttendances(List<AttendanceRequest> attendancesListRequest) {
        attendancesListRequest.forEach(attendanceRequest ->
                {
                    Attendance attendance = new Attendance();
                    attendance.setDate(attendanceRequest.date());
                    attendance.setStatus(attendanceRequest.status());
                    attendance.setStudent(attendanceRequest.student());
                    this.attendanceRepository.save(attendance);
                }
        );
    }
}
