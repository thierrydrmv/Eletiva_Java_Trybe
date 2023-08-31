package com.example.dealership.utils;

import com.example.dealership.dto.CarCreationDto;
import com.example.dealership.dto.CarDto;
import com.example.dealership.model.CarModel;

/**
 * DtoMapper.
 */
public class DtoMapper {
    /**
     * Serialização e desserialização.
     */
    public static CarDto entityToDto(CarModel car) {
        return new CarDto(
            car.getId(),
            car.getTitle(),
            car.getBrand(),
            car.getType(),
            car.getPrice()
        );
    }

    /**
     *  Serialização e desserialização.
     */
    public static CarModel dtoToEntity(CarCreationDto carCreationDto) {
        CarModel car = new CarModel();
        car.setTitle(carCreationDto.title());
        car.setBrand(carCreationDto.brand());
        car.setType(carCreationDto.type());
        car.setPrice(carCreationDto.fullPrice());

        return car;
    }
}