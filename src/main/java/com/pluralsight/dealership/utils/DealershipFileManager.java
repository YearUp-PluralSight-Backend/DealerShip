package com.pluralsight.dealership.utils;

import com.pluralsight.dealership.facade.Dealership;
import com.pluralsight.dealership.facade.VehicleInventory;
import com.pluralsight.dealership.model.Cars.Car;
import com.pluralsight.dealership.model.Cars.Vehicle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class DealershipFileManager {

    private static final String FILE_NAME = "inventory.csv";


    public static Dealership getDealerShip() {
        VehicleInventory vehicleInventory = new VehicleInventory();
        List<Vehicle> vehicles = vehicleInventory.getAllVehicles();
        Dealership dealership = null;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {

            String[] firstLineData = bufferedReader.readLine().trim().split("\\|");
            dealership = new Dealership(firstLineData[0], firstLineData[1], firstLineData[2], vehicleInventory);
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] data = line.trim().split("\\|");

                /**

                private int vin;
                private int year;
                private String make;
                private String model;
                private VehicleType vehicleType;
                private ColorCodes color;
                private int odometer;
                private double price;
                 */
                if (data[0].equalsIgnoreCase(VehicleType.SUV.toString())) {
                    Vehicle vehicle = new Car(
                            Integer.parseInt(data[0]),
                            Integer.parseInt(data[1]),
                            data[2],
                            data[3],
                            data[4],
                            ColorCodes.valueOf(data[5]),
                            Integer.parseInt(data[6]),
                            Double.parseDouble(data[7]));
                    vehicles.add(vehicle);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        InputOutput.formatOutput("You have successfully read data from file:  " + FILE_NAME + "\nTotal of vehicles is: " + vehicles.size());
        return dealership;
    }

    public static void updateAndSaveDealership(Dealership dealership) {

        List<Vehicle> allVehicles = dealership.getInventory().getAllVehicles();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))){

            bufferedWriter.write(new StringBuffer()
                    .append(dealership.getName()).append("|")
                    .append(dealership.getAddress()).append("|")
                    .append(dealership.getPhone()).toString()
            );

            for (Vehicle vehicle: allVehicles) {
                /**

                 private int vin;
                 private int year;
                 private String make;
                 private String model;
                 private VehicleType vehicleType;
                 private ColorCodes color;
                 private int odometer;
                 private double price;
                 */
                bufferedWriter.write(new StringBuilder()
                        .append(vehicle.getVin()).append("|")
                        .append(vehicle.getYear()).append("|")
                        .append(vehicle.getMake()).append("|")
                        .append(vehicle.getModel()).append("|")
                        .append(vehicle.getVehicleType()).append("|")
                        .append(vehicle.getColor()).append("|")
                        .append(vehicle.getOdometer()).append("|")
                        .append(vehicle.getPrice()).toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        InputOutput.formatOutput("You have successfully update data and save from file:  " + FILE_NAME + "\nTotal of vehicles is: " + allVehicles.size());

    }
}
