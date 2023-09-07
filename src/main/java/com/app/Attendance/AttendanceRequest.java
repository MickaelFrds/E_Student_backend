package com.app.Attendance;

import com.app.Student.Student;

import java.time.LocalDateTime;

public record AttendanceRequest(
        LocalDateTime date,
        AttendanceStatus status,
        Student student) {
}
