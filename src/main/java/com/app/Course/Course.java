package com.app.Course;


import com.app.Student.Student;
import com.app.User.User;
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
    @OneToMany(orphanRemoval=true)
    private List<Student> students;
    @OneToOne
    private User teacher;

}
