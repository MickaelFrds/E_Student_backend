package com.app.Course;


import com.app.Util.Date.Day;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private CourseService courseServices;


    @GetMapping
    public List<Course> getCourse(){
        return courseServices.getCourses();
    }

    @GetMapping("/teacher/{id}")
    public List<Course> getCoursesByTeacherId(@PathVariable Integer teacherId){
        return courseServices.getCoursesByTeacherId(teacherId);
    }

    @GetMapping("teacher/{id}/{day}")
    public List<Course> getCoursesByTeacherIdByDay(@PathVariable(name = "id") Integer id, @PathVariable(name = "day")Day day){
        return this.courseServices.getCoursesByTeacherIdByDay(day,id);

    }

    @PostMapping
    public void addCourse (CourseRequest courseRequest){
        this.courseServices.addCourse(courseRequest);
    }


}
