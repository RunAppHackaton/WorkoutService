package com.runapp.workoutservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.runapp.workoutservice.utill.DayOfTheWeeksEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RunPlan")
public class RunPlanModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "day_of_the_week")
    private int dayOfTheWeek;

    @Column(name = "starting_weekly_volume")
    private int startingWeeklyVolume;

    @Column(name = "final_date")
    private LocalDate finalDate;

    @Column(name = "user_id")
    private int userId;

    @OneToMany(mappedBy = "runPlan", cascade = CascadeType.ALL)
    private List<TrainingModel> trainingModels;
}
