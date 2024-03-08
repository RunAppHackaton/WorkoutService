package com.runapp.workoutservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RunPlan")
public class RunPlanModel implements Serializable {

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
    private String userId;

    @JsonIgnore
    @OneToMany(mappedBy = "runPlan", cascade = CascadeType.ALL)
    private List<TrainingModel> trainingModels;
}
