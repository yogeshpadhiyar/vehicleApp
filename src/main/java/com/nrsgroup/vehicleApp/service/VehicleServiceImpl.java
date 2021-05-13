package com.nrsgroup.vehicleApp.service;

import com.nrsgroup.vehicleApp.constant.Message;
import com.nrsgroup.vehicleApp.exception.CustomException;
import com.nrsgroup.vehicleApp.model.Vehicle;
import com.nrsgroup.vehicleApp.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;
    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    @Async
    public CompletableFuture<Vehicle> insertVehicle(Vehicle vehicle) {
        return CompletableFuture.completedFuture(vehicleRepository.save(vehicle));
    }

    @Override
    @Async
    public CompletableFuture<Vehicle> updateVehicle(Vehicle vehicle) {
        return CompletableFuture.completedFuture(vehicleRepository.save(vehicle));
    }

    @Override
    @Async
    public void deleteVehicle(long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    @Async
    public CompletableFuture<List<Vehicle>> findAllVehicle() {
        return CompletableFuture.completedFuture(vehicleRepository.findAll());
    }

    @Override
    @Async
    public CompletableFuture<Vehicle> findVehicleById(long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if(vehicle.isPresent()){
            return CompletableFuture.completedFuture(vehicle.get());
        }else{
            throw new CustomException(Message.VEHICLE_NOT_FOUNT, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @Async
    public CompletableFuture<List<Vehicle>> findVehicleByBrand(String brand) {
        return CompletableFuture.completedFuture(vehicleRepository.findAllByBrand(brand));
    }

    @Override
    @Async
    public CompletableFuture<List<Vehicle>> findVehicleByType(String type) {
        return CompletableFuture.completedFuture(vehicleRepository.findAllByType(type));
    }

}
