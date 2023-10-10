package com.app.Course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getCourses(){
        return this.courseRepository.findAll();
    }

    public List<Course> getCoursesByTeacherId(Integer teacherId) {
        List<Course> courses = getCourses();
        return filterByTeacherId(courses, teacherId);
    }

    public void addCourse(CourseRequest courseRequest) {
        Course newCourse = Course.builder()
                .title(courseRequest.title())
                .teacher(courseRequest.teacher())
                .students(courseRequest.students())
                .build();
        this.courseRepository.save(newCourse);
    }

    private   List<Course> filterByTeacherId(List<Course> courses, Integer teacherId){
        Stream<Course> stream = courses.stream();
        stream = stream.filter(course -> Objects.equals(course.getTeacher().getId(), teacherId));
        return stream.toList();
    }
}
