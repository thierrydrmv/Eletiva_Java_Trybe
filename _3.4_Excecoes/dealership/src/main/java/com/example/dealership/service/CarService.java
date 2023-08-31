package com.example.dealership.service;

import com.example.dealership.database.FakeDealershipDatabase;
import com.example.dealership.model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
