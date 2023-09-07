package com.app.Course;

import com.app.Student.Student;
import com.app.User.User;
import com.app.Util.Date.Day;
import com.app.Util.Date.Hours;

import java.util.List;

public record CourseRequest(
        String title,
        Day day,
        Hours startTime,
        Hours endTime,
        List<Student> students,
        User teacher
) {
}
