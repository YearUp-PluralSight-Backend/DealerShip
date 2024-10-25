package com.pluralsight.dealership.service;

import com.pluralsight.dealership.Entity.Enum.ColorCodes;
import com.pluralsight.dealership.Entity.Vehicle;

import java.util.List;

public interface VehicleInventory {

    List<Vehicle> findByPriceBetween(double min, double max);

    List<Vehicle> findByMakeAndModel(String make, String model);

    List<Vehicle> findByYearBetween(int min, int max);

    List<Vehicle> findByColor(ColorCodes color);

    List<Vehicle> findByOdometerBetween(double min, double max);

    List<Vehicle> findByVehicleType(String vehicleType);



}
