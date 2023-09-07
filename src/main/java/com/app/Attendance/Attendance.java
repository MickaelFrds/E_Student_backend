package com.app.Attendance;

import com.app.Student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attendance {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;

    @OneToOne
    private Student student;


}
