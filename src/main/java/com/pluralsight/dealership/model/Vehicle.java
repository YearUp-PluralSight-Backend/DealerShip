package com.pluralsight.dealership.model;


//import com.pluralsight.dealership.utils.ColorCodes;
//import com.pluralsight.dealership.utils.VehicleType;

/**
 * Represents a vehicle with various attributes such as VIN, year, make, model, type, color, odometer, and price.
 */
public abstract class Vehicle {

    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    /**
     * Default constructor.
     */
    public Vehicle() {

    }

    /**
     * Constructs a Vehicle with the specified attributes.
     *
     * @param vin the vehicle identification number
     * @param year the year of manufacture
     * @param make the make of the vehicle
     * @param model the model of the vehicle
     * @param vehicleType the type of the vehicle
     * @param color the color of the vehicle
     * @param odometer the odometer reading
     * @param price the price of the vehicle
     */
    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    /**
     * Gets the vehicle identification number.
     *
     * @return the vehicle identification number
     */
    public int getVin() {
        return vin;
    }

    /**
     * Sets the vehicle identification number.
     *
     * @param vin the vehicle identification number
     */
    public void setVin(int vin) {
        this.vin = vin;
    }

    /**
     * Gets the year of manufacture.
     *
     * @return the year of manufacture
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of manufacture.
     *
     * @param year the year of manufacture
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the make of the vehicle.
     *
     * @return the make of the vehicle
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the make of the vehicle.
     *
     * @param make the make of the vehicle
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets the model of the vehicle.
     *
     * @return the model of the vehicle
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the vehicle.
     *
     * @param model the model of the vehicle
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the type of the vehicle.
     *
     * @return the type of the vehicle
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * Sets the type of the vehicle.
     *
     * @param vehicleType the type of the vehicle
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * Gets the color of the vehicle.
     *
     * @return the color of the vehicle
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the vehicle.
     *
     * @param color the color of the vehicle
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the odometer reading.
     *
     * @return the odometer reading
     */
    public int getOdometer() {
        return odometer;
    }

    /**
     * Sets the odometer reading.
     *
     * @param odometer the odometer reading
     */
    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    /**
     * Gets the price of the vehicle.
     *
     * @return the price of the vehicle
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the vehicle.
     *
     * @param price the price of the vehicle
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns a string representation of the vehicle.
     *
     * @return a string representation of the vehicle
     */
    @Override
    public String toString() {
        return "Vehicle{" +
                "vin=" + vin +
                ", year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vehicleType=" + vehicleType +
                ", color=" + color +
                ", odometer=" + odometer +
                ", price=" + price +
                '}';
    }
}
