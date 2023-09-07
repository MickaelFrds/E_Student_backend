package com.app.Teacher;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService (TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher getTeacher(Integer id){
        return this.teacherRepository.findById(id).orElse(null);
    }
}
