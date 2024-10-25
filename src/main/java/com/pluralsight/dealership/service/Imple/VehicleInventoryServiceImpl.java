package com.pluralsight.dealership.service.Imple;

import com.pluralsight.dealership.Entity.Enum.ColorCodes;
import com.pluralsight.dealership.Entity.Vehicle;
import com.pluralsight.dealership.repository.VehicleRepository;
import com.pluralsight.dealership.service.VehicleInventory;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VehicleInventoryServiceImpl implements VehicleInventory {


    private final VehicleRepository vehicleRepository;


    public VehicleInventoryServiceImpl(@NotNull VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * @return vehicles
     */
    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    /**
     * @param min start price
     * @param max end price
     * @return list of vehicles
     */
    @Override
    public List<Vehicle> findByPriceBetween(@Min(value = 0, message = "Year price be greater than or equal to 0") double min, double max) {
        return vehicleRepository.findByPriceBetween(min, max).orElse(null);
    }

    /**
     * @param make  make of vehicle
     * @param model model of vehicle
     * @return list of vehicles
     */
    @Override
    public List<Vehicle> findByMakeAndModel(@NotNull(message = "Make cannot be null") String make, @NotNull(message = "Model cannot be null") String model) {
        return vehicleRepository.findByMakeAndModel(make, model).orElse(null);
    }

    /**
     * @param min start year
     * @param max end year
     * @return list of vehicles
     */
    @Override
    public List<Vehicle> findByYearBetween(@Min(value = 1900, message = "Year must be greater than or equal to 1900") int min, @Max(value = 2024, message = "Year must be less than or equal to 2024") int max) {
        return vehicleRepository.findByYearBetween(min, max).orElse(null);
    }

    /**
     * @param color color of vehicle
     * @return list of vehicles
     */
    @Override
    public List<Vehicle> findByColor(@NotNull(message = "ColorCodes cannot be null") String color) {
        return vehicleRepository.findByColor(color).orElse(null);
    }

    /**
     * @param min start odometer
     * @param max end odometer
     * @return list of vehicles
     */
    @Override
    public List<Vehicle> findByOdometerBetween(@Min(value = 0, message = "Your Odometer cannot be less then 0") double min, double max) {
        return vehicleRepository.findByOdometerBetween(min, max).orElse(null);
    }

    /**
     * @param vehicleType type of vehicle
     * @return list of vehicles
     */
    @Override
    public List<Vehicle> findByVehicleType(@NotNull(message = "Vehicle Type cannot be Null") String vehicleType) {
        return vehicleRepository.findByVehicleType(vehicleType).orElse(null);
    }

    /**
     * @param vehicle Vehicle
     * @return Vehicle
     */
    @Override
    public Vehicle addVehicle(@NotNull(message = "Vehicle cannot be null") Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    /**
     * @param id vehicle id
     */
    @Override
    public void removeVehicleByVin(@Min(value = 1, message = "id cannot be 0 or negative") int id) {
        vehicleRepository.deleteById(id);
    }

    /**
     * @param vehicle vehicle
     * @param id      id of vehicle
     * @return true if it updated successfully.
     */
    @Override
    public boolean UpdateVehicleByVin(@NotNull(message = "Vehicle cannot be null") Vehicle vehicle, @Min(value = 1, message = "id cannot be 0 or negative") int id) {

//        Vehicle oldVehicle = vehicleRepository.findById(id).orElse(null);
//        assert oldVehicle != null;
//        oldVehicle.setVin(vehicle.getVin());
//        oldVehicle.setVehicleType(vehicle.getVehicleType());
//        oldVehicle.setMake(vehicle.getMake());
//        oldVehicle.setYear(vehicle.getYear());
//        oldVehicle.setModel(vehicle.getModel());
//        oldVehicle.setPrice(vehicle.getPrice());
//        oldVehicle.setColor(vehicle.getColor());
//        oldVehicle.setOdometer(vehicle.getOdometer());

        return true;


    }

    /**
     * @param id vehicle id
     * @return Vehicle
     */
    @Override
    public Vehicle findById(@Min(value = 1, message = "id cannot be 0 or negative") int id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    /**
     * @param vehicleList
     * @return
     */
    @Override
    public boolean addAllVehicles(List<Vehicle> vehicleList) {
        List<Vehicle> vehicles = vehicleRepository.saveAll(vehicleList);
        return true;
    }
}
