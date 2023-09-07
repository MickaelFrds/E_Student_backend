package com.app.Student;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(StudentRequest studentRequest){
        Student student =new Student();
        student.setFirstName(studentRequest.firstName());
        student.setLastName(studentRequest.lastName());
        student.setAge(studentRequest.age());
        this.studentRepository.save(student);
    }

    public void deleteStudent(Integer id){
        this.studentRepository.deleteById(id);
    }
}
