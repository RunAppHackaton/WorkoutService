package com.runapp.workoutservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Route")
public class RouteModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<RoutePointModel> routePoints;

    public RouteModel(List<RoutePointModel> routePoints) {
        this.routePoints = routePoints;
    }
}
