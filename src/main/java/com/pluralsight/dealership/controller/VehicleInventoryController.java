package com.pluralsight.dealership.controller;


import com.pluralsight.dealership.Entity.Vehicle;
import com.pluralsight.dealership.Entity.Enum.ColorCodes;
import com.pluralsight.dealership.service.VehicleInventory;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/vehicles")
public class VehicleInventoryController {

    private final VehicleInventory vehicleInventory;

    public VehicleInventoryController(VehicleInventory vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }

    @GetMapping("/dealerName")
    public ResponseEntity<String> getDealershipName() {

        return ResponseEntity.of(Optional.of("dealership"));
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleInventory.findAll();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/price")
    public ResponseEntity<List<Vehicle>> getVehiclesByPrice(
            @RequestParam @Min(0) double min,
            @RequestParam double max) {
        List<Vehicle> vehicles = vehicleInventory.findByPriceBetween(min, max);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/make-model")
    public ResponseEntity<List<Vehicle>> getVehiclesByMakeAndModel(
            @RequestParam String make,
            @RequestParam String model) {
        List<Vehicle> vehicles = vehicleInventory.findByMakeAndModel(make, model);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/year")
    public ResponseEntity<List<Vehicle>> getVehiclesByYear(
            @RequestParam @Min(1900) int min,
            @RequestParam @Min(1900) int max) {
        List<Vehicle> vehicles = vehicleInventory.findByYearBetween(min, max);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/color")
    public ResponseEntity<List<Vehicle>> getVehiclesByColor(@RequestParam String color) {
        List<Vehicle> vehicles = vehicleInventory.findByColor(color);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/odometer")
    public ResponseEntity<List<Vehicle>> getVehiclesByOdometer(
            @RequestParam @Min(0) double min,
            @RequestParam double max) {
        List<Vehicle> vehicles = vehicleInventory.findByOdometerBetween(min, max);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/type")
    public ResponseEntity<List<Vehicle>> getVehiclesByType(@RequestParam String vehicleType) {
        List<Vehicle> vehicles = vehicleInventory.findByVehicleType(vehicleType);
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@Valid @RequestBody Vehicle vehicle) {
        Vehicle savedVehicle = vehicleInventory.addVehicle(vehicle);
        return ResponseEntity.status(201).body(savedVehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeVehicle(@PathVariable @Min(1) int id) {
        vehicleInventory.removeVehicleByVin(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVehicle(@PathVariable @Min(1) int id,
                                              @Valid @RequestBody Vehicle vehicle) {
        boolean updated = vehicleInventory.UpdateVehicleByVin(vehicle, id);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable @Min(1) int id) {
        Vehicle vehicle = vehicleInventory.findById(id);
        return vehicle != null ? ResponseEntity.ok(vehicle) : ResponseEntity.notFound().build();
    }

    @GetMapping("/delete")
    public ResponseEntity<Boolean> deleteAllVehicles() {
        vehicleInventory.removeAllVehicles();
        return ResponseEntity.of(Optional.of(true));
    }
}

