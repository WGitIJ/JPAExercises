package JPA.model;

import jakarta.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Cossos.tots", query = "SELECT c FROM Cossos c")
})
@Entity
@Table(name = "cossos")
public class Cossos {
    @Id
    private String idCos;
    private String descripcio;

    public Cossos() {
    }

    public Cossos(String idCos, String descripcio) {
        this.idCos = idCos;
        this.descripcio = descripcio;
    }

    public String getIdCos() {
        return idCos;
    }

    public void setIdCos(String idCos) {
        this.idCos = idCos;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public String toString() {
        return "Cossos{" +
                "idCos='" + idCos + '\'' +
                ", descripcio='" + descripcio + '\'' +
                '}';
    }
}
