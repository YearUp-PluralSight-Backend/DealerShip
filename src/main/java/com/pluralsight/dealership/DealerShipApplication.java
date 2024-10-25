package com.pluralsight.dealership;

import com.pluralsight.dealership.Entity.Vehicle;
import com.pluralsight.dealership.repository.VehicleRepository;
import com.pluralsight.dealership.utils.LoadDataToDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DealerShipApplication implements CommandLineRunner {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public DealerShipApplication(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DealerShipApplication.class, args);
    }

    @Override
    public void run(String... args) {
        List<Vehicle> vehicles = LoadDataToDataBase.loadData();
        vehicleRepository.saveAll(vehicles);
        System.out.println("Vehicles loaded into the database.");
    }
}
