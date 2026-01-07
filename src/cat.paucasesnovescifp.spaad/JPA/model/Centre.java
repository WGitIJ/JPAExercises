package JPA.model;

import jakarta.persistence.*;

@Entity
@Table(name = "centres")
public class Centre {
    @Id
    private String idCentre;
    private String nomCentre;
    @ManyToOne
    @JoinColumn(name = "idLocalitat")
    private Localitat localitat;

    public Centre() {
    }
    public Centre(String idCentre, String nomCentre, Localitat localitat) {
        this.idCentre = idCentre;
        this.nomCentre = nomCentre;
        this.localitat = localitat;
    }

    public String getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(String idCentre) {
        this.idCentre = idCentre;
    }

    public String getNomCentre() {
        return nomCentre;
    }

    public void setNomCentre(String nomCentre) {
        this.nomCentre = nomCentre;
    }

    public Localitat getLocalitat() {
        return localitat;
    }

    public void setLocalitat(Localitat localitat) {
        this.localitat = localitat;
    }

    @Override
    public String toString() {
        return "Centre{" +
                "idCentre='" + idCentre + '\'' +
                ", nomCentre='" + nomCentre + '\'' +
                ", localitat=" + localitat +
                '}';
    }
}
