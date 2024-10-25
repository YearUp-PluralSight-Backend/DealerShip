package com.pluralsight.dealership.Entity;


//import com.pluralsight.dealership.utils.ColorCodes;
//import com.pluralsight.dealership.utils.VehicleType;

import com.pluralsight.dealership.Entity.Enum.ColorCodes;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a vehicle with various attributes such as VIN, year, make, model, type, color, odometer, and price.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private ColorCodes color;
    private int odometer;
    private double price;

}
