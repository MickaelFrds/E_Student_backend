package com.app.Teacher;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teacher/")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeachers(){
        return this.teacherService.getTeachers();
    }

    @GetMapping("{id}")
    public Teacher getTeacherById(@PathVariable Integer id){
        return this.teacherService.getTeacher(id);
    }


}
