package com.runapp.workoutservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Training")
public class TrainingModel implements Serializable {

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
    @JoinColumn(name = "Stage_id")
    private StageModel stage;

    @ManyToOne
    @JoinColumn(name = "RunType_id")
    private RunTypeModel runType;

    @ManyToOne()
    @JoinColumn(name = "RunPlan_id")
    @JsonIgnore
    private RunPlanModel runPlan;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<IntervalModel> intervalModelList;
}
