package com.runapp.workoutservice.model;

import com.runapp.workoutservice.utill.TrainingTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RunType")
public class RunTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type_name")
    @Enumerated(EnumType.STRING)
    private TrainingTypeEnum typeName;

    @Column(name = "description")
    private String description;

    @Column(name = "intervals")
    private int intervals;

    @Column(name = "runtype_image_url")
    private String runtypeImageUrl;
}
