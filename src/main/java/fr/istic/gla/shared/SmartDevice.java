package fr.istic.gla.shared;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yoannlt on 24/04/15.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DeviceType", discriminatorType = DiscriminatorType.STRING)
public abstract class SmartDevice implements Serializable {
    private Long id;
    private int conso;
    private Home home;

    public SmartDevice(){};

    public SmartDevice(int conso, Home home){
        this.conso = conso;
        this.home = home;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getConso() {
        return conso;
    }

    public void setConso(int conso) {
        this.conso = conso;
    }

    @ManyToOne
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

}
