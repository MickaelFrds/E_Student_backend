package com.app.Course;

import com.app.Util.Date.Day;
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


    public List<Course> getCourseByDay(Day day){
        List<Course> courses = getCourses();
        return getCoursesFilterByDay(courses, day);
    }

    public List<Course> getCoursesByTeacherId(Integer teacherId) {
        List<Course> courses= getCourses();
        return getCourseFilterByTeacherId(courses, teacherId);
    }

    public List<Course> getCoursesByTeacherIdByDay (Day day, Integer teacherId){
        List<Course> coursesByTeacherId = getCoursesByTeacherId(teacherId);
        return getCoursesFilterByDay(coursesByTeacherId, day);
    }

    public List<Course> getCoursesFilterByDay(List<Course> courses,Day day){
        Stream<Course> stream = courses.stream();
        stream = stream.filter(course -> course.getDay() == day);
        return stream.toList();
    }

    public  List<Course> getCourseFilterByTeacherId(List<Course> courses, Integer teacherId){
        Stream<Course> stream = courses.stream();
        stream = stream.filter(course -> Objects.equals(course.getTeacher().getId(), teacherId));
        return stream.toList();
    }

    public void addCourse(CourseRequest courseRequest) {
        Course course = Course.builder()
                .title(courseRequest.title())
                .teacher(courseRequest.teacher())
                .students(courseRequest.students())
                .endTime(courseRequest.endTime())
                .startTime(courseRequest.startTime())
                .day(courseRequest.day())
                .build();
        this.courseRepository.save(course);
    }
}
