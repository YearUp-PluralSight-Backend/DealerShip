package com.pluralsight.dealership.facade;

import com.pluralsight.dealership.factory.MiniVanFactory;
import com.pluralsight.dealership.factory.SUVFactory;
import com.pluralsight.dealership.factory.SedanFactory;
import com.pluralsight.dealership.factory.TruckFactory;
import com.pluralsight.dealership.model.Cars.Vehicle;
import com.pluralsight.dealership.utils.ColorCodes;
import com.pluralsight.dealership.utils.VehicleType;

import java.util.ArrayList;
import java.util.List;

import static com.pluralsight.dealership.utils.InputOutput.formatOutput;
import static com.pluralsight.dealership.utils.VehicleType.*;

public class VehicleInventory {

    private final List<Vehicle> inventory = new ArrayList<>();
    private int totalOfVehicles;

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return inventory.stream()
                .filter(vehicle -> vehicle.getPrice() >= min && vehicle.getPrice() <= max)
                .toList();
    }

    // Method to get vehicles by make and model
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        // Implementation here
        return inventory.stream()
                .filter(vehicle -> vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model))
                .toList();
    }

    // Method to get vehicles by year range
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        // Implementation here
        return inventory.stream()
                .filter(vehicle -> vehicle.getYear() >= min && vehicle.getYear() <= max)
                .toList();
    }

    // Method to get vehicles by color
    public List<Vehicle> getVehiclesByColor(ColorCodes color) {
        // Implementation here
        return inventory.stream()
                .filter(vehicle -> vehicle.getColor().equals(color)).toList();
    }

    // Method to get vehicles by mileage range
    public List<Vehicle> getVehiclesByMileage(double min, double max) {
        // Implementation here
        return inventory.stream()
                .filter(vehicle -> vehicle.getOdometer() >= min && vehicle.getOdometer() <= max)
                .toList();
    }

    // Method to get vehicles by type
    public List<Vehicle> getVehiclesByType(VehicleType vehicleType) {
        // Implementation here
        return inventory.stream()
                .filter(vehicle -> vehicle.getVehicleType().equals(vehicleType))
                .toList();
    }

    // Method to get all vehicles in inventory
    public List<Vehicle> getAllVehicles() {
        // Implementation here
        return inventory;
    }

    // Method to add a vehicle to the inventory
    public void addVehicle(Vehicle vehicle) {
        // Implementation here

        boolean successfully = true;
        if (vehicle.getVehicleType().equals(SUV)) inventory.add(new SUVFactory().createVehicle(vehicle));
        else if (vehicle.getVehicleType().equals(MINIVAN)) inventory.add(new MiniVanFactory().createVehicle(vehicle));
        else if (vehicle.getVehicleType().equals(TRUCK)) inventory.add(new TruckFactory().createVehicle(vehicle));
        else if (vehicle.getVehicleType().equals(SEDAN)) inventory.add(new SedanFactory().createVehicle(vehicle));
        else {
            formatOutput("Sorry, Vehicle Type Wrong!");
            successfully = false;
        }

        if (successfully) {
            totalOfVehicles++;
        }




    }

    // Method to remove a vehicle from the inventory
    public boolean removeVehicle(Vehicle vehicle) {
        // Implementation here
        totalOfVehicles--;
        return inventory.remove(vehicle);
    }

    // Optional: Method to get the total number of vehicles
    public int getTotalOfVehicles() {
        // Implementation here
        return totalOfVehicles;
    }

    public void setTotalOfVehicles() {
        this.totalOfVehicles = inventory.size();
    }
}
