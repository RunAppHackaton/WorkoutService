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
    private long id;

    @Column(name = "type_name")
    @Enumerated(EnumType.STRING)
    private TrainingTypeEnum typeName;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "runtype_image_url")
    private String runtypeImageUrl;

    public RunTypeModel(long id) {
        this.id = id;
    }
}
