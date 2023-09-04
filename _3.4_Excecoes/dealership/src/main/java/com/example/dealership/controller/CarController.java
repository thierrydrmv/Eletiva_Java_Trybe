package com.example.dealership.controller;

import com.example.dealership.dto.CarCreationDto;
import com.example.dealership.dto.CarDto;
import com.example.dealership.dto.EditCarCreationDto;
import com.example.dealership.model.CarModel;
import com.example.dealership.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    /**
     * endpoint GET/:id.
     */
    @GetMapping({"/{id}"})
    public ResponseEntity<CarDto> getCar(@PathVariable String id) {
        CarModel car = carService.getCarById(id);
        if (car == null) {
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(entityToDto(car));
    }

    /**
     * endpoint POST.
     */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createCar(@RequestBody CarCreationDto carCreationDto) {
        CarModel car = carService.createCar(carCreationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(car.getId());
    }

    /**
     * endpoint PUT.
     */

    @PutMapping
    public ResponseEntity<String> setDiscount(@RequestBody EditCarCreationDto editCarCreationDto) {
        CarModel car = carService.setDiscount(editCarCreationDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(car.getId());
    }

    /**
     * endpoint DELETE.
     */

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        Optional<CarModel> car = carService.removeCar(id);
        if (car.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
