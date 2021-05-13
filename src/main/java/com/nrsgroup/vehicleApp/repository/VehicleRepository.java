package com.nrsgroup.vehicleApp.repository;

import com.nrsgroup.vehicleApp.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findAllByBrand(String brand);

    List<Vehicle> findAllByType(String type);
}
