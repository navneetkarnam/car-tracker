package io.navneetkarnam.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

//Creating Vehicle Entity

@Entity
@NamedQuery(name = "vehicle.findAll", query = "SELECT cars FROM vehicle cars ORDER BY cars.vin ")
public class vehicle {

    @Id
    @Column(columnDefinition = "VARCHAR(17)")
    private String vin;

    private String make;
    private String model;
    private Integer year;
    private String lastServiceDate;
    private Integer maxFuelVolume;
    private Integer redlineRpm;

    //getters and setters

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public Integer getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(Integer maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Integer getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(Integer redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    //toString method
    @Override
    public String toString() {
        return "vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", lastServiceDate='" + lastServiceDate + '\'' +
                ", maxFuelVolume=" + maxFuelVolume +
                ", redlineRpm=" + redlineRpm +
                '}';
    }
}
