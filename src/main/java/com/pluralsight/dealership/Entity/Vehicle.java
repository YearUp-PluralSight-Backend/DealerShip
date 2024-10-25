package com.pluralsight.dealership.Entity;


import com.pluralsight.dealership.Entity.Enum.ColorCodes;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a vehicle with various attributes such as VIN, year, make, model, type, color, odometer, and price.
 */
// https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-constraint-violation-methods

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int vin;

    @Min(value = 1900, message = "Year must be greater than or equal to 1900")
    @Max(value = 2024, message = "Year must be less than or equal to 2024")
    @Column()
    private int year;

    @Column
    @NotNull(message = "Make cannot be null")
    @Size(min = 2, max = 30, message = "Make must be between 1 and 30 characters")
    private String make;

    @NotNull(message = "Model cannot be null")
    @Size(min = 1, max = 30, message = "Model must be between 2 and 30 characters")
    private String model;

    @NotNull(message = "Vehicle Type cannot be null")
    @Size(min = 1, max = 30, message = "Vehicle Type must be between 2 and 30 characters")
    private String vehicleType;

    @NotNull(message = "Color cannot be null")
    private String color;

    @Min(value = 0, message = "Year odometer be greater than or equal to 0")
    @Max(value = 10000000, message = "Year odometer be less than or equal to 10000000")
    private int odometer;

    @Min(value = 0, message = "Year price be greater than or equal to 0")
    @NotNull(message = "Price cannot be null")
    private double price;

}
