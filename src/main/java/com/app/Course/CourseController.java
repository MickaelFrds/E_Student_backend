package com.app.Course;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseServices;


    @GetMapping
    public List<Course> getCourses(){
        return this.courseServices.getCourses();
    }

    @GetMapping("/teacher/{id}")
    public List<Course> getCoursesByTeacherId(@PathVariable(name = "id") Integer teacherId){
        return this.courseServices.getCoursesByTeacherId(teacherId);
    }

    @PostMapping
    public void addCourse (@RequestBody CourseRequest courseRequest){
        this.courseServices.addCourse(courseRequest);
    }


}
