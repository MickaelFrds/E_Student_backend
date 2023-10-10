package com.app.Course;

import com.app.Student.Student;
import com.app.User.User;


import java.util.List;

public record CourseRequest(
        String title,
        List<Student> students,
        User teacher
) {
}
