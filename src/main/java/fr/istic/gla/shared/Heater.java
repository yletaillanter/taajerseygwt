package fr.istic.gla.shared;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by yoannlt on 24/04/15.
 */
@Entity
@DiscriminatorValue("Heater")
public class Heater extends SmartDevice  {

    public Heater(){};

    public Heater(int conso, Home home) {
        super(conso, home);
        // TODO Auto-generated constructor stub
    }

}
