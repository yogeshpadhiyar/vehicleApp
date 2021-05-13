package com.nrsgroup.vehicleApp.controller;

import com.nrsgroup.vehicleApp.model.Vehicle;
import com.nrsgroup.vehicleApp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/nrs")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping(value = "/addVehicle", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> addVehicle(@Valid @RequestBody Vehicle vehicle, BindingResult result){
        return null;

    }

    @GetMapping(value = "/allVehicle")
    public ResponseEntity<Object> allVehicle(){
        return null;
    }

    @GetMapping(value = "/allVehicle/brand={brand}")
    public ResponseEntity<Object> allVehicleByBrand(@PathVariable(value = "brand") String brand){
        return null;
    }

    @GetMapping(value = "/allVehicle/type={type}")
    public ResponseEntity<Object> allVehicleByType(@PathVariable(value = "type") String brand){
        return null;
    }

    @PutMapping(value = "/updateVehicle/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> updateVehicle(@PathVariable(value = "id")long id,
                                                @Valid @RequestBody Vehicle vehicle, BindingResult result){
        return null;
    }

    @DeleteMapping(value = "/deleteVehicle/{id}")
    public ResponseEntity<Object> deleteVehicle(@PathVariable(value = "id")long id){
        return null;
    }

}
