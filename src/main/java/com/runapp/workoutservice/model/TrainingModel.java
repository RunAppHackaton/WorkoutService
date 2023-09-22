package com.runapp.workoutservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Training")
public class TrainingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "kilometers")
    private double kilometers;

    @Column(name = "warm_up")
    private double warmUp;

    @Column(name = "hitch")
    private double hitch;

    @ManyToOne
    @JoinColumn(name = "Stage_id", referencedColumnName = "id")
    private StageModel stage;

    @ManyToOne
    @JoinColumn(name = "RunType_id", referencedColumnName = "id")
    private RunTypeModel runType;

    @ManyToOne
    @JoinColumn(name = "RunPlan_id", referencedColumnName = "id")
    private RunPlanModel runPlan;

    @OneToMany(mappedBy = "training", cascade = CascadeType.REMOVE)
    private List<IntervalModel> intervalModelList;
}
