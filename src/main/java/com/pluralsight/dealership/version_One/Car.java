package com.pluralsight.dealership.version_One;

import com.pluralsight.dealership.Entity.Enum.ColorCodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {

    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private ColorCodes color;
    private int odometer;
    private double price;

}
