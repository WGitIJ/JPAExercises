package JPA.model;

import JPA.help.JPAException;
import jakarta.persistence.*;

@NamedQuery(name = "getNifs", query = "SELECT a.NIF FROM Aspirant a ORDER BY llinatges")
@Entity
@Table(name = "aspirants")
public class Aspirant {
    @Id
    private String NIF;
    private String nom;
    private String llinatges;
    private String adreca;
    private String codiPostal;
    @ManyToOne
    @JoinColumn(name = "idLocalitat")
    private Localitat localitat;


    public Aspirant() {

    }

    public Aspirant(String NIF, String nom, String llinatges, String adreca, String codiPostal, Localitat localitat) {
        this.NIF = NIF;
        this.nom = nom;
        this.llinatges = llinatges;
        this.adreca = adreca;
        this.codiPostal = codiPostal;
        this.localitat = localitat;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLlinatges() {
        return llinatges;
    }

    public void setLlinatges(String llinatges) {
        this.llinatges = llinatges;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        if(adreca.isBlank()){
            throw new JPAException("L'adreça no pot estar buida");
        }
        this.adreca = adreca;
    }

    public String getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(String codiPostal) {
        this.codiPostal = codiPostal;
    }

    public Localitat getLocalitat() {
        return localitat;
    }

    public void setLocalitat(Localitat localitat) {
        this.localitat = localitat;
    }

    @Override
    public String toString() {
        return "Aspirant{" +
                "NIF='" + NIF + '\'' +
                ", nom='" + nom + '\'' +
                ", llinatges='" + llinatges + '\'' +
                ", adreca='" + adreca + '\'' +
                ", codiPostal='" + codiPostal + '\'' +
                ", localitat='" + localitat + '\'' +
                '}';
    }
}
