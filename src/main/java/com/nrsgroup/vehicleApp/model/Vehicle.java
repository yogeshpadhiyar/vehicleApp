package com.nrsgroup.vehicleApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String brand;
    private String type;
    private String fuelType;
    private float maxSpeed;
    private int modelReleaseYear;
    private String breakType;

}
