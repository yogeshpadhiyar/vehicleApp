package com.nrsgroup.vehicleApp.service;

import com.nrsgroup.vehicleApp.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {

    Vehicle insertVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Vehicle vehicle);

    void  deleteVehicle(long id);

    List<Vehicle> findAllVehicle();

    Vehicle findVehicleById(long id);

    List<Vehicle> findVehicleByBrand(String brand);

    List<Vehicle> findVehicleByType(String type);
}
