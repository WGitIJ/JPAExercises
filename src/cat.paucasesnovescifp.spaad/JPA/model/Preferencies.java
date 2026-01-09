package JPA.model;

import jakarta.persistence.*;

@Entity
@Table(name = "preferencies")
@IdClass(PreferenciesPK.class)
public class Preferencies {
    @Id
    @ManyToOne
    @JoinColumn(name = "Nif")
    private Aspirant aspirant;

    @Id
    private int ordre;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "idCos") ,
            @JoinColumn(name = "idEspecialitat")
    })
    private Especialitat especialitat;
    @ManyToOne
    @JoinColumn(name = "idCentre")
    private Centre centre;

    public Preferencies() {

    }

    public Preferencies(Aspirant aspirant, int ordre, Especialitat especialitat, Centre centre) {
        this.aspirant = aspirant;
        this.ordre = ordre;
        this.especialitat = especialitat;
        this.centre = centre;
    }

    public Aspirant getAspirant() {
        return aspirant;
    }

    public void setAspirant(Aspirant aspirant) {
        this.aspirant = aspirant;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public Especialitat getEspecialitat() {
        return especialitat;
    }

    public void setEspecialitat(Especialitat especialitat) {
        this.especialitat = especialitat;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    @Override
    public String toString() {
        return "Preferencies{" +
                "aspirant=" + aspirant +
                ", ordre=" + ordre +
                ", especialitat=" + especialitat +
                ", centre=" + centre +
                '}';
    }
}
