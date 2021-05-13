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
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/nrs")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping(value = "/addVehicle", produces = "application/json", consumes = "application/json")
    public CompletableFuture<ResponseEntity> addVehicle(@Valid @RequestBody Vehicle vehicle, BindingResult result){
        if(!result.hasErrors()){
            return vehicleService.insertVehicle(vehicle).thenApply(ResponseEntity::ok);
        }else{
            return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_VALID_JSON));
        }
    }

    @GetMapping(value = "/allVehicle")
    public CompletableFuture<ResponseEntity> allVehicle(){
        return vehicleService.findAllVehicle().thenApply(ResponseEntity::ok);

    }

    @GetMapping(value = "/allVehicle/brand={brand}")
    public CompletableFuture<ResponseEntity> allVehicleByBrand(@PathVariable(value = "brand") String brand){
        return vehicleService.findVehicleByBrand(brand).thenApply(ResponseEntity::ok);

    }

    @GetMapping(value = "/allVehicle/type={type}")
    public CompletableFuture<ResponseEntity> allVehicleByType(@PathVariable(value = "type") String type){
        return vehicleService.findVehicleByType(type).thenApply(ResponseEntity::ok);
    }

    @GetMapping(value = "/vehicle/id={id}")
    public CompletableFuture<ResponseEntity> VehicleDetail(@PathVariable(value = "id") long id){
        return vehicleService.findVehicleById(id).thenApply(ResponseEntity::ok);
    }

    @PutMapping(value = "/updateVehicle/{id}", produces = "application/json", consumes = "application/json")
    public CompletableFuture<ResponseEntity> updateVehicle(@PathVariable(value = "id")long id,
                                                @Valid @RequestBody Vehicle vehicle, BindingResult result){
        if(!result.hasErrors()){
            vehicleService.findVehicleById(id).thenAccept(vehicle1 -> vehicle.setId(vehicle1.getId()));
            System.out.println(vehicle.getId());
            return vehicleService.updateVehicle(vehicle).thenApply(ResponseEntity::ok);

        }else{
            return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message.NOT_VALID_JSON));
        }
    }

    @DeleteMapping(value = "/deleteVehicle/{id}")
    public ResponseEntity<Object> deleteVehicle(@PathVariable(value = "id")long id){
        vehicleService.findVehicleById(id);
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(Message.VEHICLE_DELETE, HttpStatus.OK);
    }

}
