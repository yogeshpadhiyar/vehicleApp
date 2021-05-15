package com.nrsgroup.vehicleApp.service;

import com.nrsgroup.vehicleApp.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface VehicleService {

    CompletableFuture<Vehicle> insertVehicle(Vehicle vehicle);

    CompletableFuture<Vehicle> updateVehicle(Vehicle vehicle);

    CompletableFuture<String>  deleteVehicle(long id);

    CompletableFuture<List<Vehicle>> findAllVehicle();

    CompletableFuture<Vehicle> findVehicleById(long id);

    CompletableFuture<List<Vehicle>> findVehicleByBrand(String brand);

    CompletableFuture<List<Vehicle>> findVehicleByType(String type);
}
