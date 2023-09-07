package com.app.Student;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public List<Student> getStudents(){
        return this.studentService.getStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody StudentRequest studentRequest){
        this.studentService.addStudent(studentRequest);
    }
}
