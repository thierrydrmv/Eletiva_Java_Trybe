package com.example.dealership.database;
import com.example.dealership.model.CarModel;

import java.util.List;

/**
 * Interface for database requests.
 */
public interface DealershipDatabaseInterface {

    List <CarModel> getAllCars();

    CarModel getCarById(String id);

    CarModel addCar(String title, String brand, String type, double fullPrice);

    CarModel setDiscount(String id);

    CarModel removeCar(String id);
}

