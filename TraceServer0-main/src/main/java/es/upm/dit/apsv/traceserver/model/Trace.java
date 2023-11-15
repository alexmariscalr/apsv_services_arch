package es.upm.dit.apsv.traceserver.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Trace {
    @Id
    private String id;
    private String truck;
    private long lastSeen;
    private double lat;
    private double lon;

    public Trace(String id, String truck, long lastSeen, double lat, double lon) {
        this.id = id;
        this.truck = truck;
        this.lastSeen = lastSeen;
        this.lat = lat;
        this.lon = lon;
    }

}
