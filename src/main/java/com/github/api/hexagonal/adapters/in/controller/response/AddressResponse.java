package com.github.api.hexagonal.adapters.in.controller.response;


public class AddressResponse {

    public AddressResponse(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    private String street;

    private String city;

    private String state;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
