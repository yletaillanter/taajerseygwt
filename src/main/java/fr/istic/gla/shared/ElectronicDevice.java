package fr.istic.gla.shared;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by yoannlt on 24/04/15.
 */
@Entity
@DiscriminatorValue("ElectronicDevice")
public class ElectronicDevice extends SmartDevice {

    public ElectronicDevice(){}

    public ElectronicDevice(int conso, Home home) {
        super(conso, home);
        // TODO Auto-generated constructor stub
    }

}
