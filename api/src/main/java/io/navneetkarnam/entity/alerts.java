package io.navneetkarnam.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//Creating alerts Entity

import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "alerts.alertsList", query = "SELECT alerts FROM alerts alerts "),
        @NamedQuery(name = "alerts.alertsByVin", query = "SELECT alert FROM alerts alert WHERE alert.carVin = :paramVin "),
        @NamedQuery(name = "alerts.alertsHigh", query = "SELECT alert FROM alerts alert WHERE alert.priority = 'HIGH' "),
        @NamedQuery(name = "alerts.highByVin", query = "SELECT alert FROM alerts alert WHERE alert.priority = 'HIGH' AND alert.carVin = :paramVin")
}
)
public class alerts {

    @Id
    private String id;
    private String carVin;
    private String cause;
    private String priority;
    private String timestamp;

    //Constructors
    public alerts(){

    }

    public alerts(String carVin, String cause, String priority, String Date){
        this.id = UUID.randomUUID().toString();
        this.carVin = carVin;
        this.cause = cause;
        this.priority = priority;
        this.timestamp = Date;

    }

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    //toString method
    @Override
    public String toString() {
        return "alerts{" +
                "id='" + id + '\'' +
                ", carVin='" + carVin + '\'' +
                ", cause='" + cause + '\'' +
                ", priority='" + priority + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
