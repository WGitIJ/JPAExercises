package JPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "illes")
public class Illa {
    @Id
    private String idIlla;
    private String nomIlla;

    public Illa() {
    }

    public Illa(String idIlla, String nomIlla) {
        this.idIlla = idIlla;
        this.nomIlla = nomIlla;
    }

    public Illa(String idIlla) {
        this.idIlla = idIlla;
    }

    public String getIdIlla() {
        return idIlla;
    }

    public void setIdIlla(String idIlla) {
        this.idIlla = idIlla;
    }

    public String getNomIlla() {
        return nomIlla;
    }

    public void setNomIlla(String nomIlla) {
        this.nomIlla = nomIlla;
    }

    @Override
    public String toString() {
        return "Illa{" +
                "idIlla='" + idIlla + '\'' +
                ", nomIlla='" + nomIlla + '\'' +
                '}';
    }
}
