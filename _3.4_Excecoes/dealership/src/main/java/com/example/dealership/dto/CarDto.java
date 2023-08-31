package com.example.dealership.dto;

/**
 * Data Transfer Object.
 * @param id
 * @param title
 * @param brand
 * @param Type
 * @param fullPrice
 */
public record CarDto(String id, String title, String brand, String Type, Double fullPrice) {
}
