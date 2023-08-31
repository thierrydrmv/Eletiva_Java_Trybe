package com.example.dealership.controller;

import com.example.dealership.dto.CarDto;
import com.example.dealership.model.CarModel;
import com.example.dealership.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.example.dealership.utils.DtoMapper.entityToDto;

/**
 * Car Controller.
 */
@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }
    /**
     * endpoint GET.
     */
    @GetMapping
    public ResponseEntity<List<CarDto>> getCars() {
        List<CarDto> cars = new ArrayList<>();
        for (CarModel car: carService.getAllCars()){
            cars.add(
                    entityToDto(car)
            );
        }
        return ResponseEntity.ok(cars);
    }
}
