package com.pluralsight.dealership.service.Imple;

import com.pluralsight.dealership.Entity.Enum.ColorCodes;
import com.pluralsight.dealership.Entity.Vehicle;
import com.pluralsight.dealership.repository.VehicleRepository;
import com.pluralsight.dealership.service.VehicleInventory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VehicleInventoryServiceImpl implements VehicleInventory {


    private VehicleRepository vehicleRepository;


    public VehicleInventoryServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * @param min
     * @param max
     * @return
     */
    @Override
    public List<Vehicle> findByPriceBetween(double min, double max) {
        vehicleRepository.findByPriceBetween(min, max);

        return null;
    }

    /**
     * @param make
     * @param model
     * @return
     */
    @Override
    public List<Vehicle> findByMakeAndModel(String make, String model) {
        return List.of();
    }

    /**
     * @param min
     * @param max
     * @return
     */
    @Override
    public List<Vehicle> findByYearBetween(int min, int max) {
        return List.of();
    }

    /**
     * @param color
     * @return
     */
    @Override
    public List<Vehicle> findByColor(ColorCodes color) {
        return List.of();
    }

    /**
     * @param min
     * @param max
     * @return
     */
    @Override
    public List<Vehicle> findByOdometerBetween(double min, double max) {
        return List.of();
    }

    /**
     * @param vehicleType
     * @return
     */
    @Override
    public List<Vehicle> findByVehicleType(String vehicleType) {
        return List.of();
    }
}
