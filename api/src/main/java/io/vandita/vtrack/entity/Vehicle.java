package io.chaithanya.egen.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name="Vehicle.getAll",
                    query = "SELECT vehicle FROM Vehicle vehicle"),
        @NamedQuery(name="Vehicle.getByVin",
                    query= "SELECT vehicle FROM Vehicle vehicle WHERE vehicle.vin=:paramVin")
})
public class Vehicle {

    @Id
    String vin;
    String make;
    String model;
    int year;
    int redlineRpm;
    int maxFuelVolume;
    String lastServiceDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getReadlineRpm() {
        return redlineRpm;
    }

    public void setReadlineRpm(int readlineRpm) {
        this.redlineRpm = readlineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
}
