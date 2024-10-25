package com.pluralsight.dealership.utils;

import com.pluralsight.dealership.Entity.Enum.ColorCodes;
import com.pluralsight.dealership.Entity.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadDataToDataBase {

    private static final String FILE_NAME = "inventory.csv";

    public static List<Vehicle> loadData() {
        List<Vehicle> vehicles = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            bufferedReader.readLine();
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
                Vehicle vehicle = new Vehicle(
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputOutput.formatOutput("You have successfully read data from file:  " + FILE_NAME + "\nTotal of vehicles is: " + vehicles.size());
        return vehicles;
    }
}
