package com.pluralsight.dealership.version_One;


import com.pluralsight.dealership.utils.InputOutput;

import java.util.ArrayList;
import java.util.List;

public class CommandLineInterface {

    private static Dealership dealership = DealershipFileManager.getDealerShip();
    private static CommandLineInterface commandLineInterface;
    private static  VehicleInventory carInventory;
    private List<Car> carList;

    private CommandLineInterface(){
        dealership = DealershipFileManager.getDealerShip();
        carInventory = dealership.getInventory();
        carList = new ArrayList<>();
    }

    public static CommandLineInterface getInstance() {

        if(commandLineInterface == null) {
            commandLineInterface = new CommandLineInterface();
            return commandLineInterface;
        }
        return commandLineInterface;
    }


    private void homeScreen() {

        boolean flag = true;
        while (flag) {
            try {
                menu();  // Display the car dealership menu
                String command = InputOutput.promptForString(" (Dealership) Enter your Option: ").toUpperCase();
                switch (command) {
                    case "1" -> display();                         // Display all vehicles
                    case "2" -> processGetByPriceRequest();        // Search by price range
                    case "3" -> processGetByMakeModelRequest();    // Search by make and model
                    case "4" -> processGetByYearRequest();         // Search by year
                    case "5" -> processGetByColorKequest();        // Search by color
                    case "6" -> processGetByMileageRequest();      // Search by mileage
                    case "7" -> processGetByVehicleTypeRequest();  // Search by vehicle type
                    case "8" -> processGetAllVehicleaRequest();    // Display all vehicles
                    case "9" -> processAddVehicleRequest();        // Add a new vehicle
                    case "10" -> rocessRemoveVehicleRequest();     // Remove a vehicle
                    case "0" -> flag = false;                      // Exit the application
                    default -> System.out.println("Invalid Option. Please choose a number between 0 and 10.\n");
                }
            } catch (Exception e) {
                System.out.println("Wrong command or option!");
                e.printStackTrace();
            }
        }

    }

    private void menu() {
        String info =
                """
                Welcome to the Car Dealership Inventory System
                Please select an option:
                1. Display all vehicles
                2. Search vehicles by price range
                3. Search vehicles by make and model
                4. Search vehicles by year
                5. Search vehicles by color
                6. Search vehicles by mileage
                7. Search vehicles by vehicle type
                8. Display all vehicles
                9. Add a new vehicle to the inventory
                10. Remove a vehicle from the inventory
                0. Exit
                """;

        System.out.println(info);
    }


    private void display() {
        carList.forEach(System.out::println);
    }

    public void processGetByPriceRequest(){
        Double min = InputOutput.promptForDouble("Enter the min price: ");
        Double max = InputOutput.promptForDouble("Enter the max price: ");
        carInventory.getVehiclesByPrice(min, max).forEach(System.out::println);
    }
    public void processGetByMakeModelRequest(){}

    public void processGetByYearRequest(){}

    public void processGetByColorKequest(){}

    public void processGetByMileageRequest(){}

    public void processGetByVehicleTypeRequest(){}

    public void processGetAllVehicleaRequest(){}

    public void processAddVehicleRequest(){}

    public void rocessRemoveVehicleRequest(){}


    
}
