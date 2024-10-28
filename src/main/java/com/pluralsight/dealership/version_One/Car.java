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
    private String color;
    private int odometer;
    private double price;


    @Override
    public String toString() {
        return String.format(
                "%-10d %-6d %-15s %-15s %-12s %-10s %,15d $%,10.2f",
                vin, year, make, model, vehicleType, color, odometer, price
        );
}


}
