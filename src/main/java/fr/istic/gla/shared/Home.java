package fr.istic.gla.shared;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoannlt on 24/04/15.
 */
@Entity
public class Home implements Serializable {
    private Long id;
    private Address address;
    private float area;
    private String ip;
    private Person owner;

    private List<SmartDevice> devices;

    public Home(){

    }

    public Home(Address address, float area, String ip, Person owner){
        this.address = address;
        this.area = area;
        this.ip = ip;
        this.owner = owner;
        this.devices = new ArrayList<SmartDevice>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
    public List<SmartDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<SmartDevice> devices) {
        this.devices = devices;
    }

    @Override
    public String toString(){
        return address.getNumber()
                +" "+address.getStreet()
                +" "+address.getZipCode()
                +" "+address.getCity();
    }

}

