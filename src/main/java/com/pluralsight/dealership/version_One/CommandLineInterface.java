package com.pluralsight.dealership.version_One;


import com.pluralsight.dealership.utils.InputOutput;

import java.util.ArrayList;
import java.util.List;

public class CommandLineInterface {

    private static Dealership dealership;
    private static CommandLineInterface commandLineInterface;
    private static  VehicleInventory carInventory;
    private final List<Car> carList;

    private CommandLineInterface(){
        dealership = DealershipFileManager.getDealerShip();
        carInventory = dealership.getInventory();
        carList = carInventory.getAllVehicles();
        homeScreen();
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
                printMenu();  // Display the car dealership menu
                String command = InputOutput.promptForString(" (Dealership) Enter your Option: ").toUpperCase();
                switch (command) {
                    case "1" -> display();                         // Display all vehicles
                    case "2" -> processGetByPriceRequest();        // Search by price range
                    case "3" -> processGetByMakeModelRequest();    // Search by make and model
                    case "4" -> processGetByYearRequest();         // Search by year
                    case "5" -> processGetByColorRequest();        // Search by color
                    case "6" -> processGetByMileageRequest();      // Search by mileage
                    case "7" -> processGetByVehicleTypeRequest();  // Search by vehicle type
                    case "8" -> processGetAllVehicleRequest();    // Display all vehicles
                    case "9" -> processAddVehicleRequest();        // Add a new vehicle
                    case "10" -> processRemoveVehicleRequest();     // Remove a vehicle
                    case "0" -> flag = false;                      // Exit the application
                    default -> System.out.println("Invalid Option. Please choose a number between 0 and 10.\n");
                }
            } catch (Exception e) {
                System.out.println("Wrong command or option!");
                e.printStackTrace();
            }
        }

    }

    private void printMenu() {
        String info =
                """
                %s|%s|%s
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
                """.formatted(dealership.getName(), dealership.getAddress(), dealership.getPhone());

        System.out.println(info);
    }


    private void display() {
        InputOutput.loadingAnimation();
        InputOutput.header();
        carList.forEach(System.out::println);
        InputOutput.footer(carList);
        InputOutput.printEndingPrompt();
    }

    public void processGetByPriceRequest(){
        Double min = InputOutput.promptForDouble("Enter the min price: ");
        Double max = InputOutput.promptForDouble("Enter the max price: ");
        InputOutput.loadingAnimation();
        InputOutput.header();
        carInventory.getVehiclesByPrice(min, max).forEach(System.out::println);
        InputOutput.footer(carList);
        InputOutput.printEndingPrompt();

    }
    public void processGetByMakeModelRequest(){
        String make = InputOutput.promptForString("Enter the Make: ");
        String model = InputOutput.promptForString("Enter the Model: ");
        InputOutput.loadingAnimation();
        InputOutput.header();
        carInventory.getVehiclesByMakeModel(make,model);
        InputOutput.footer(carList);
        InputOutput.printEndingPrompt();
    }

    public void processGetByYearRequest(){
        int startYear = InputOutput.promptForInteger("Enter the start year: ");
        int endYear = InputOutput.promptForInteger("Enter the end year: ");
        InputOutput.loadingAnimation();
        InputOutput.header();
        carInventory.getVehiclesByYear(startYear, endYear).forEach(System.out::println);
        InputOutput.footer(carList);
        InputOutput.printEndingPrompt();
    }

    public void processGetByColorRequest(){
        String color = InputOutput.promptForString("Enter the color: ");
        InputOutput.loadingAnimation();
        InputOutput.header();
        carInventory.getVehiclesByColor(color).forEach(System.out::println);
        InputOutput.footer(carList);

        InputOutput.printEndingPrompt();

    }

    public void processGetByMileageRequest(){
        double min = InputOutput.promptForDouble("Enter the min mileage: ");
        double max = InputOutput.promptForDouble("Enter the max mileage: ");
        InputOutput.loadingAnimation();
        InputOutput.header();
        carInventory.getVehiclesByMileage(min, max).forEach(System.out::println);
        InputOutput.footer(carList);
        InputOutput.printEndingPrompt();
    }

    public void processGetByVehicleTypeRequest(){
        String vehicleType = InputOutput.promptForString("Enter the vehicle type: ");
        InputOutput.loadingAnimation();
        InputOutput.header();
        carInventory.getVehiclesByType(vehicleType).forEach(System.out::println);
        InputOutput.footer(carList);
        InputOutput.printEndingPrompt();
    }

    public void processGetAllVehicleRequest(){
        InputOutput.loadingAnimation();
        InputOutput.header();
        carList.forEach(System.out::println);
        InputOutput.footer(carList);
        InputOutput.printEndingPrompt();
    }

    public void processAddVehicleRequest(){
        InputOutput.loadingAnimation();
        Car car = InputOutput.carObject();
        carList.add(car);
        InputOutput.printEndingPrompt();

    }

    public void processRemoveVehicleRequest(){
        InputOutput.loadingAnimation();
        Car car = InputOutput.carObject();
        carList.remove(car);
        InputOutput.printEndingPrompt();


    }


    
}
