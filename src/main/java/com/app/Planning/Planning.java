package com.app.Planning;


import com.app.TimeSlot.TimeSlot;
import com.app.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Planning {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id")
    private User teacher;
    @OneToMany
    private List<TimeSlot> timeSlots;

}
