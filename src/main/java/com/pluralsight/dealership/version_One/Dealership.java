package com.pluralsight.dealership.facade;

public class Dealership {

    private String name;
    private String Address;
    private String phone;
    private VehicleInventory inventory;

    public Dealership() {
    }

    public Dealership(String name, String address, String phone, VehicleInventory inventory) {
        this.name = name;
        Address = address;
        this.phone = phone;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public VehicleInventory getInventory() {
        return inventory;
    }

    public void setInventory(VehicleInventory inventory) {
        this.inventory = inventory;
    }
}
