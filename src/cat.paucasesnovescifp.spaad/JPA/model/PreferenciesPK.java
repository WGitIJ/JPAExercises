package JPA.model;

import jakarta.persistence.Id;

public class PreferenciesPK {
    private Aspirant aspirant;

    private int ordre;

    public PreferenciesPK(Aspirant aspirant, int ordre) {
        this.aspirant = aspirant;
        this.ordre = ordre;
    }

    public PreferenciesPK(){

    }

    @Override
    public String toString() {
        return "PreferenciesPK{" +
                "aspirant='" + aspirant + '\'' +
                ", ordre=" + ordre +
                '}';
    }
}
