package JPA.model;

import jakarta.persistence.*;

@NamedQuery(name = "tornaLocalitatsIlla", query = "Select l from Localitat l where l.illa = :illa")
@Entity
@Table(name = "localitats")
public class Localitat {
    @Id
    private String idLocalitat;
    @ManyToOne
    @JoinColumn(name = "idIlla")
    private Illa illa;
    private String nomLocalitat;

    public Localitat(){

    }

    public Localitat(String idLocalitat, Illa illa, String nomLocalitat) {
        this.idLocalitat = idLocalitat;
        this.illa = illa;
        this.nomLocalitat = nomLocalitat;
    }

    public String getIdLocalitat() {
        return idLocalitat;
    }

    public void setIdLocalitat(String idLocalitat) {
        this.idLocalitat = idLocalitat;
    }

    public Illa getIlla() {
        return illa;
    }

    public void setIlla(Illa illa) {
        this.illa = illa;
    }

    public String getNomLocalitat() {
        return nomLocalitat;
    }

    public void setNomLocalitat(String nomLocalitat) {
        this.nomLocalitat = nomLocalitat;
    }

    @Override
    public String toString() {
        return "Localitat{" +
                "idLocalitat='" + idLocalitat + '\'' +
                ", idIlla='" + illa + '\'' +
                ", nomLocalitat='" + nomLocalitat + '\'' +
                '}';
    }
}
