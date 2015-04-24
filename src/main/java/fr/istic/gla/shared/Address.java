package fr.istic.gla.shared;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by yoannlt on 24/04/15.
 */
@Embeddable
public class Address implements Serializable {
    private int number;
    private String street;
    private int zipCode;
    private String city;

    public Address() {
    }

    public Address(int number, String street, int zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.getNumber() + ' ' + this.getStreet() + ' ' + this.getZipCode() + ' ' + this.getCity();
    }

}