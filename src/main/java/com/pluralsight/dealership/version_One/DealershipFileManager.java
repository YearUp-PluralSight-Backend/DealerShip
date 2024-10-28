package com.pluralsight.dealership.version_One;

import com.pluralsight.dealership.Entity.Enum.ColorCodes;
import com.pluralsight.dealership.utils.InputOutput;
import lombok.Getter;

import java.io.*;
import java.util.List;

public class DealershipFileManager {

    private static final String FILE_NAME = "inventory.csv";

    @Getter
    private static String dealershipName;

    @Getter
    private static String dealershipAddress;

    @Getter
    private static String dealershipPhoneNumber;

    public static void getDealerShipInfo() {

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
            String[] firstLineData = bufferedReader.readLine().trim().split("\\|");
            firstLineData[0] = dealershipName;
            firstLineData[1] = dealershipAddress;
            firstLineData[2] = dealershipPhoneNumber;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Dealership getDealerShip() {
        VehicleInventory vehicleInventory = new VehicleInventory();
        List<Car> vehicles = vehicleInventory.getAllVehicles();
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
                    Car vehicle = new Car(
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
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputOutput.formatOutput("You have successfully read data from file:  " + FILE_NAME + "\nTotal of vehicles is: " + vehicles.size());
        return dealership;
    }

    public static void updateAndSaveDealership(Dealership dealership) {

        List<Car> allVehicles = dealership.getInventory().getAllVehicles();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))){

            bufferedWriter.write(new StringBuffer()
                    .append(dealership.getName()).append("|")
                    .append(dealership.getAddress()).append("|")
                    .append(dealership.getPhone()).toString()
            );

            for (Car vehicle: allVehicles) {
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
