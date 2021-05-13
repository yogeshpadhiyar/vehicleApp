package com.nrsgroup.vehicleApp.controller;

import com.nrsgroup.vehicleApp.constant.Message;
import com.nrsgroup.vehicleApp.model.Vehicle;
import com.nrsgroup.vehicleApp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        if(!result.hasErrors()){
            vehicle = vehicleService.insertVehicle(vehicle);
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(Message.NOT_VALID_JSON, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/allVehicle")
    public ResponseEntity<Object> allVehicle(){
        List<Vehicle> vehicleList = vehicleService.findAllVehicle();
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @GetMapping(value = "/allVehicle/brand={brand}")
    public ResponseEntity<Object> allVehicleByBrand(@PathVariable(value = "brand") String brand){
        List<Vehicle> vehicleList = vehicleService.findVehicleByBrand(brand);
        return new ResponseEntity<>(vehicleList,HttpStatus.OK);
    }

    @GetMapping(value = "/allVehicle/type={type}")
    public ResponseEntity<Object> allVehicleByType(@PathVariable(value = "type") String type){
        List<Vehicle> vehicleList = vehicleService.findVehicleByType(type);
        return new ResponseEntity<>(vehicleList,HttpStatus.OK);
    }

    @GetMapping(value = "/vehicle/id={id}")
    public ResponseEntity<Object> VehicleDetail(@PathVariable(value = "id") long id){
        Vehicle vehicle = vehicleService.findVehicleById(id);
        return new ResponseEntity<>(vehicle,HttpStatus.OK);
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
