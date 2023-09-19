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
@Table(name = "RunType")
public class RunTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name")
    private String type_name;

    @Column(name = "description")
    private String description;

    @Column(name = "intervals")
    private String intervals;

    @Column(name = "runtype_image_url")
    private String runtypeImageUrl;

    @OneToMany(mappedBy = "runType")
    private List<RunSessionModel> runSessionModelList;

    @OneToMany(mappedBy = "runTypeModel")
    private List<RunPlanModel> runPlanModels;
}
