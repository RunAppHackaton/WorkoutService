package com.runapp.workoutservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Route")
public class RouteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_location")
    private String startLocation;

    @Column(name = "end_location")
    private String endLocation;

    @Column(name = "route_map_url")
    private String routeMapUrl;

    @OneToOne
    @JoinColumn(name = "run_session_id", referencedColumnName = "id")
    private RunSessionModel runSession;
}
