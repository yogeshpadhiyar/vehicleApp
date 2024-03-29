package com.nrsgroup.vehicleApp.controller;

import com.nrsgroup.vehicleApp.exception.CustomException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VehicleErrorAdvice {
    @ExceptionHandler({CustomException.class, EmptyResultDataAccessException.class})
    public ResponseEntity<Object> handleCustomException(CustomException e){
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }
}
