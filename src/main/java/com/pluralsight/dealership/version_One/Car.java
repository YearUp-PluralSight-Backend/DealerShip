package com.pluralsight.dealership.model.Cars;

import com.pluralsight.dealership.utils.ColorCodes;

public class Car extends Vehicle {


    public Car(int vin, int year, String make, String model, String vehicleType, ColorCodes color, int odometer, double price) {
        super(vin, year, make, model, vehicleType, color, odometer, price);

    }
}
