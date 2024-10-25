package com.pluralsight.dealership.version_One;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dealership {

    private String name;
    private String Address;
    private String phone;
    private VehicleInventory inventory;

}
