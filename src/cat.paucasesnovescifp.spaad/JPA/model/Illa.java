package JPA.model;

import jakarta.persistence.*;
import jdk.jfr.Name;

import java.util.List;


@NamedQuery(name = "tornaIlles", query = "Select i from Illa i")
@Entity
@Table(name = "illes")
public class Illa {
    @Id
    private String idIlla;
    private String nomIlla;
    @OneToMany(mappedBy = "illa", fetch = FetchType.EAGER) //Esto es para que se cargue siempre para los OneToMany
    private List<Localitat> localitats;

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

    public List<Localitat> getLocalitats() {
        return localitats;
    }

    public void setLocalitats(List<Localitat> localitats) {
        this.localitats = localitats;
    }

    @Override
    public String toString() {
        return "Illa{" +
                "idIlla='" + idIlla + '\'' +
                ", nomIlla='" + nomIlla + '\'' +
                '}';
    }
}
