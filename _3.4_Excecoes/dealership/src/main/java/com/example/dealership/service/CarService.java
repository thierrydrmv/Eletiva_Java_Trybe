package com.example.dealership.service;

import com.example.dealership.database.FakeDealershipDatabase;
import com.example.dealership.dto.CarCreationDto;
import com.example.dealership.dto.EditCarCreationDto;
import com.example.dealership.model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Car Service.
 */
@Service
public class CarService {
    private final FakeDealershipDatabase fakeDealershipDatabase;
    @Autowired
    public CarService(FakeDealershipDatabase fakeDealershipDatabase) {
        this.fakeDealershipDatabase = fakeDealershipDatabase;
    }

    public List<CarModel> getAllCars() {
        return fakeDealershipDatabase.getAllCars();
    }

    public CarModel getCarById(String id) {
        return fakeDealershipDatabase.getCarById(id);
    }

    public CarModel createCar(CarCreationDto car) {
        return fakeDealershipDatabase.addCar(
                car.title(),
                car.brand(),
                car.type(),
                car.fullPrice()
        );
    }

    public CarModel setDiscount(EditCarCreationDto editCarCreationDto) {
        return fakeDealershipDatabase.setDiscount(
                editCarCreationDto.id(),
                editCarCreationDto.title(),
                editCarCreationDto.brand(),
                editCarCreationDto.type(),
                editCarCreationDto.fullPrice(),
                editCarCreationDto.discount()
        );
    }

    public Optional<CarModel> removeCar(String id) {
        return Optional.of(fakeDealershipDatabase.removeCar(id));
    }
}
