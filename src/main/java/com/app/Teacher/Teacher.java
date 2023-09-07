package com.app.Teacher;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String mail;


}
