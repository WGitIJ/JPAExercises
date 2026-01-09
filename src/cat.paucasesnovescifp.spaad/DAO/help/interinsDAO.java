package DAO.help;

import JPA.model.Aspirant;
import JPA.model.Illa;
import JPA.model.Localitat;
import JPA.model.Preferencies;

import java.util.List;
import java.util.prefs.Preferences;

public interface interinsDAO {
    Aspirant recuperarAspirant(String nif);
    void modificarLlinatge(String llinatge, String nif);
    void actualitzaAspirant(Aspirant aspirant);
    void crearAspirant(Aspirant aspirant);
    void crearObjecte(Object object);
    void updateObject(Object object);
    void deleteObject(Object object);

    List<Illa> tornaIlles();

    List<Illa> tornaIllesNamedQuery();
    List<Localitat> tornaLocalitatsIlla(Illa illa);
    List<Localitat> tornaLocalitatsIlla2(Illa illa);

    List<Localitat> tornaLocalitatsIllesNamedQuery(Illa illa);

    List<Aspirant> tornaAspirants(int inici, int quantitat);

    List<String> getNifs(int inici, int quantitat);

    List<String> getNomComplet(int inici, int quanitat);

    List<Preferencies> getPreferences(int inici, int quantitat);

}
