package io.chaithanya.egen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Date;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "Priority.getAllAlerts",
                    query="SELECT pr FROM Priority pr"),
        @NamedQuery(name="Priority.getByVin",
                    query = "SELECT priority FROM Priority priority WHERE priority.vin=:paramVin")
})
public class Priority {

    @Id
    String id;
    String vin;
    String priority;
    String message;
    Date timestamp;

    public Priority() {
    }

    public Priority(String vin, String priority, String message, Date timestamp) {
        this.id = UUID.randomUUID().toString();
        this.vin = vin;
        this.priority = priority;
        this.message = message;
        this.timestamp = timestamp;

    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
