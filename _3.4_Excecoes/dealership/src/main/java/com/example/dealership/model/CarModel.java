package com.example.dealership.model;

import java.util.UUID;

/**
 * Define CarModel model. This is a internal representation of a Car with
 * getters and setters to provide acess to the data.
 */
public class CarModel {
    String id;
    String title;
    String brand;
    String type;
    Double fullPrice;
    Double discount;
    public CarModel() {}

    public CarModel(String title, String brand, String type, Double fullPrice) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.brand = brand;
        this.type = type;
        this.fullPrice = fullPrice;
    }

    public CarModel(String id, String title, String brand, String type, Double fullPrice, Double discount) {
        this.id = id;
        this.title = title;
        this.brand = brand;
        this.type = type;
        this.fullPrice = fullPrice;
        this.setPrice(fullPrice - fullPrice * discount/100);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return fullPrice;
    }

    public void setPrice(Double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
