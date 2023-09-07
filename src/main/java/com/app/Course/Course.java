package com.app.Course;


import com.app.Student.Student;
import com.app.User.User;
import com.app.Util.Date.Day;
import com.app.Util.Date.Hours;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Day day;

    @Enumerated(EnumType.STRING)
    private Hours startTime;

    private Hours endTime;

    @OneToMany
    private List<Student> students;

    @OneToOne
    private User teacher;

}
