package DAO.help;

import JPA.model.Aspirant;
import JPA.model.Illa;

import java.util.List;

public interface interinsDAO {
    Aspirant recuperarAspirant(String nif);
    void modificarLlinatge(String llinatge, String nif);
    void actualitzaAspirant(Aspirant aspirant);
    void crearAspirant(Aspirant aspirant);
    void crearObjecte(Object object);
    void updateObject(Object object);
    void deleteObject(Object object);

    List<Illa> tornaIlles();

}
