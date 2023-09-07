package com.app.Course;

import com.app.Util.Date.Day;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses(){
        return this.courseRepository.findAll();
    }

    public List<Course> getCoursesByIds(List<Integer> ids){
        return this.courseRepository.findAllById(ids);
    }

    public List<Course> getCourseByDay(Day day){
        List<Course> courses = getCourses();
        Stream<Course> stream = courses.stream();
        stream = stream.filter(course -> course.getDay() == day);
        return stream.toList();
    }

}
