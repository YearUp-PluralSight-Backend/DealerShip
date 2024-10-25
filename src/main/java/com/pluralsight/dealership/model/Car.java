package com.pluralsight.dealership.model;

public class Car extends Vehicle{


    /**
     * Default constructor.
     */
    public Car() {
    }

    /**
     * Constructs a Vehicle with the specified attributes.
     *
     * @param vin         the vehicle identification number
     * @param year        the year of manufacture
     * @param make        the make of the vehicle
     * @param model       the model of the vehicle
     * @param vehicleType the type of the vehicle
     * @param color       the color of the vehicle
     * @param odometer    the odometer reading
     * @param price       the price of the vehicle
     */
    public Car(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        super(vin, year, make, model, vehicleType, color, odometer, price);
    }
}
