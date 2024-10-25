package com.pluralsight.dealership.repository;

import com.pluralsight.dealership.Entity.Enum.ColorCodes;
import com.pluralsight.dealership.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//https://docs.spring.io/spring-data/jpa/reference/jpa.html

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {


    Optional<List<Vehicle>> findByPriceBetween(double min, double max);

    Optional<List<Vehicle>> findByMakeAndModel(String make, String model);

    Optional<List<Vehicle>> findByYearBetween(int min, int max);

    Optional<List<Vehicle>> findByColor(String color);

    Optional<List<Vehicle>> findByOdometerBetween(double min, double max);

    Optional<List<Vehicle>> findByVehicleType(String vehicleType);


}
