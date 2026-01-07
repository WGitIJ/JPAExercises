package JPA.model;

import jakarta.persistence.*;

@Entity
@Table(name = "especialitats")
@IdClass(EspecialitatPK.class)
public class Especialitat {
    @Id
    private String idCos;
    @Id
    private String idEspecialitat;
    private String descripcio;

    public Especialitat() {
    }

    public Especialitat(String idCos, String idEpecialitat, String descripcio) {
        this.idCos = idCos;
        this.idEspecialitat = idEpecialitat;
        this.descripcio = descripcio;
    }

    public String getIdCos() {
        return idCos;
    }

    public void setIdCos(String idCos) {
        this.idCos = idCos;
    }

    public String getIdEspecialitat() {
        return idEspecialitat;
    }

    public void setIdEspecialitat(String idEspecialitat) {
        this.idEspecialitat = idEspecialitat;
    }

    @Override
    public String toString() {
        return "Especialitat{" +
                "idCos='" + idCos + '\'' +
                ", idEspecialitat='" + idEspecialitat + '\'' +
                '}';
    }
}
