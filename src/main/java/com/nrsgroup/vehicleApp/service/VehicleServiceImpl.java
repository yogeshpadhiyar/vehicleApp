package com.nrsgroup.vehicleApp.service;

import com.nrsgroup.vehicleApp.constant.Message;
import com.nrsgroup.vehicleApp.exception.CustomException;
import com.nrsgroup.vehicleApp.model.Vehicle;
import com.nrsgroup.vehicleApp.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return vehicleRepository.save(vehicle);
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
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findVehicleById(long id) {
        return vehicleRepository.findById(id).orElseThrow(()->new CustomException(Message.VEHICLE_NOT_FOUNT, HttpStatus.BAD_REQUEST));
    }

    @Override
    public List<Vehicle> findVehicleByBrand(String brand) {
        return vehicleRepository.findAllByBrand(brand);
    }

    @Override
    public List<Vehicle> findVehicleByType(String type) {
        return vehicleRepository.findAllByType(type);
    }

}
