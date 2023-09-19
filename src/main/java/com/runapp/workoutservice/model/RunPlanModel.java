package com.runapp.workoutservice.model;

import com.runapp.workoutservice.utill.DayOfTheWeeksEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_the_week")
    private DayOfTheWeeksEnum dayOfTheWeek;

    @ManyToOne
    @JoinColumn(name = "runtype_id")
    private RunTypeModel runTypeModel;

    @Column(name = "distance")
    private int distance;

    @Column(name = "duration")
    private LocalDateTime duration;

    @Column(name = "pace")
    private BigDecimal pace;

    @Column(name = "note")
    private String note;

    @Column(name = "user_id")
    private int user;

    @OneToMany(mappedBy = "runPlan")
    private List<IntervalsModel> intervalsModelList;
}
