# Car Dealership Inventory System Workshop

## Overview

This workshop project is designed to create a car dealership inventory management system in Java. The system allows users to manage a collection of vehicles, providing functionalities such as adding new cars, viewing the inventory, and managing dealership information. The project emphasizes object-oriented design principles, focusing on class relationships and clean code practices.

## Components

### 1. Dealership Class
- **Purpose:** Represents the dealership entity, encapsulating its details and the vehicle inventory.
- **Attributes:**
    - `name`: The name of the dealership.
    - `address`: The address of the dealership.
    - `phone`: The contact number of the dealership.
    - `inventory`: An instance of the `VehicleInventory` class that holds all vehicles available for sale.
- **Methods:**
    - `addVehicle(Car car)`: Adds a vehicle to the inventory.
    - `removeVehicle(Car car)`: Removes a vehicle from the inventory.
    - `viewInventory()`: Displays all vehicles in the inventory.

### 2. VehicleInventory Class
- **Purpose:** Manages a collection of vehicles available at the dealership.
- **Attributes:**
    - `vehicles`: A list or collection that stores `Car` objects.
- **Methods:**
    - `addCar(Car car)`: Adds a car to the inventory.
    - `removeCar(Car car)`: Removes a car from the inventory.
    - `listCars()`: Lists all cars currently in the inventory.

### 3. Car Class
- **Purpose:** Represents individual car objects, encapsulating attributes specific to each vehicle.
- **Attributes:**
    - `make`: The manufacturer of the car.
    - `model`: The model of the car.
    - `year`: The manufacturing year of the car.
    - `price`: The selling price of the car.
- **Methods:**
    - `getDetails()`: Returns a string containing details about the car.

### 4. InputOutput Class
- **Purpose:** Handles user input and output operations, facilitating interaction with the system.
- **Methods:**
    - `getUserInput()`: Prompts the user for input.
    - `displayMessage(String message)`: Displays messages to the user.

### 5. CommandLineInterface Class
- **Purpose:** Provides a command-line interface for users to interact with the dealership system.
- **Methods:**
    - `showMenu()`: Displays the main menu of options.
    - `executeCommand(int command)`: Executes the selected command based on user input.

## Relationships Between Classes

- **Dealership and VehicleInventory:**
    - The `Dealership` class contains an instance of the `VehicleInventory` class, establishing a **has-a** relationship. The dealership relies on the inventory to manage its vehicles.

- **Dealership and Car:**
    - The `Dealership` class interacts with the `Car` class through the `VehicleInventory`. It uses `Car` objects to represent the vehicles available in the inventory.

- **VehicleInventory and Car:**
    - The `VehicleInventory` class contains a collection of `Car` objects, indicating a **contains** relationship. This class manages the lifecycle of cars within the inventory.

## Interesting Code Features

### 1. Header and Footer Formatting
- Implementing a consistent header and footer format across the application enhances the user interface. This can be achieved using methods in the `CommandLineInterface` class that print decorative lines and the application title.

```java
 public static void header() {
    System.out.println();
    System.out.printf("%-10s %-6s %-15s %-15s %-12s %-10s %-15s %-10s%n",
            "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");
    System.out.println("----------------------------------------------------------------------------------------------------");

}


public static void footer(List<Car> carList) {
    double totalValue = carList.stream().mapToDouble(Car::getPrice).sum();
    System.out.println("----------------------------------------------------------------------------------------------------");
    System.out.printf("Total Cars: %-10d Total Inventory Value: $%,.2f%n", carList.size(), totalValue);

}
```

### 2. Loading Animation
- A simple loading animation can improve user experience while waiting for operations to complete. This can be implemented using a separate thread to display animated dots or a spinner during long-running tasks.

```java
    public static void loadingAnimation() {

    try {
        System.out.print("Loading.");
        System.out.print(".");
        Thread.sleep(1000);
        System.out.print(".");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println();
}
```

## Conclusion

This car dealership inventory system project provides a solid foundation for understanding object-oriented design in Java. By structuring classes effectively and implementing user-friendly features, this workshop demonstrates how to build a practical application while emphasizing clean code and maintainability.
