package com.nrsgroup.vehicleApp.service;

import com.nrsgroup.vehicleApp.model.Vehicle;
import com.nrsgroup.vehicleApp.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;
    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle insertVehicle(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return null;
    }

    @Override
    public void deleteVehicle(long id) {

    }

    @Override
    public List<Vehicle> findAllVehicle() {
        return null;
    }

    @Override
    public Vehicle findVehicleById(long id) {
        return null;
    }

    @Override
    public List<Vehicle> findVehicleByBrand(String brand) {
        return null;
    }

    @Override
    public List<Vehicle> findVehicleByType(String type) {
        return null;
    }
}
