package org.example;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String StreetName;
    private int ApartmentNumber;

    public String getStreetName() {
        return StreetName;
    }

    public int getApartmentNumber() {
        return ApartmentNumber;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public void setApartmentNumber(int apartmentNumber) {
        ApartmentNumber = apartmentNumber;
    }

}
