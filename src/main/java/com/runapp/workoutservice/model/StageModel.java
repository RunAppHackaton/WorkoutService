package com.runapp.workoutservice.model;

import com.runapp.workoutservice.utill.enums.StageEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Stage")
public class StageModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name_enum")
    @Enumerated(EnumType.STRING)
    private StageEnum stageEnum;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 1000)
    private String description;

    public StageModel(long id) {
        this.id = id;
    }
}
