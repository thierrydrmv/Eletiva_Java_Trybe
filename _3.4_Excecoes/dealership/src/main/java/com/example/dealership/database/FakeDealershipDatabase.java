package com.example.dealership.database;

import com.example.dealership.dto.EditCarCreationDto;
import com.example.dealership.model.CarModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implements TaskDatabase interface but it is not a real database since it resets to initial state
 * when application resets (no data persistence).
 */
@Component
public class FakeDealershipDatabase implements  DealershipDatabaseInterface{

    private Map<String, CarModel> cars = new HashMap<>();
    @Override
    public List<CarModel> getAllCars() {
        return new ArrayList<>(cars.values());

    }

    @Override
    public CarModel getCarById(String id) {
        return cars.get(id);
    }

    @Override
    public CarModel addCar(String title, String brand, String type, double fullPrice) {
        CarModel newCar = new CarModel(title, brand, type, fullPrice);
        cars.put(newCar.getId(), newCar);
        return newCar;
    }

    @Override
    public CarModel setDiscount(String id, String title, String brand, String type, double fullPrice, double discount) {
        CarModel newCar = new CarModel(id, title, brand, type, fullPrice, discount);
        removeCar(id);
        cars.put(newCar.getId(), newCar);
        return newCar;
    }

    @Override
    public CarModel removeCar(String id) {
        return cars.remove(id);
    }
}
