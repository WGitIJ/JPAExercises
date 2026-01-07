package JPA.model;

import java.io.Serializable;

public class EspecialitatPK implements Serializable{
    private String idCos;
    private String idEspecialitat;

    public EspecialitatPK() {
    }

    public EspecialitatPK(String idCos, String idEpecialitat) {
        this.idCos = idCos;
        this.idEspecialitat = idEpecialitat;
    }

    public void setIdCos(String idCos) {
        this.idCos = idCos;
    }

    public void setIdEspecialitat(String idEspecialitat) {
        this.idEspecialitat = idEspecialitat;
    }

    public String getIdCos() {
        return idCos;
    }

    public String getIdEspecialitat() {
        return idEspecialitat;
    }
}
