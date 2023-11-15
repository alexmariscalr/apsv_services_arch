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
    private double lat; // Latitud
    private double lon; // Longitud

    // Constructor con todos los atributos
    public Trace(String id, String truck, long lastSeen, double lat, double lon) {
        this.id = id;
        this.truck = truck;
        this.lastSeen = lastSeen;
        this.lat = lat;
        this.lon = lon;
    }

    // Métodos hashCode y equals para comparar objetos Trace
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Trace trace = (Trace) obj;
        return id.equals(trace.id);
    }
}
