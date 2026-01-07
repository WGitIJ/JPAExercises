package JPA.test;

import jakarta.persistence.*;
import JPA.model.Aspirant;
import JPA.model.Centre;
import JPA.model.Cossos;
import JPA.model.Localitat;

import java.util.List;

public class ProvesJPA {
    private String unitatPersistencia;

    public ProvesJPA(String unitatPersistencia) {
        this.unitatPersistencia = unitatPersistencia;
    }

    public String getUnitatPersistencia() {
        return unitatPersistencia;
    }

    public void setUnitatPersistencia(String unitatPersistencia) {
        if (unitatPersistencia.isEmpty() || unitatPersistencia.isBlank() || unitatPersistencia == null) {
            throw new IllegalArgumentException("La unitat de persistència no pot ser buida ni només espais en blanc ni nul·la.");
        }else {
            this.unitatPersistencia = unitatPersistencia;
        }
    }

    public Centre tornaCentre(String idCentre) {
        Centre centre;
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia); EntityManager manager = factory.createEntityManager()) {
             centre = manager.find(Centre.class, idCentre);
        }
        return centre;
    }

    public Boolean modifcaAdrecaAspirant(String nif, String adreca){
        Boolean isModified = false;
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia); EntityManager manager = factory.createEntityManager()) {
            manager.getTransaction().begin();
            Aspirant aspirant = manager.find(Aspirant.class, nif);
            aspirant.setAdreca(adreca);
            manager.getTransaction().commit();
            isModified = true;
        }
        return isModified;
    }

    public void actualitzaCentre(Centre centre){
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia); EntityManager manager = factory.createEntityManager()) {
            manager.getTransaction().begin();
            manager.merge(centre);
            manager.getTransaction().commit();

        }
    }

    public Centre creaCentra(String idCentre, String nom, Localitat localitat){
        Centre centre = new Centre(idCentre, nom, localitat);
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia); EntityManager manager = factory.createEntityManager()) {
            manager.getTransaction().begin();
            manager.persist(centre);
            manager.getTransaction().commit();
        }
        return centre;
    }

    public void esborra(Object object){
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia); EntityManager manager = factory.createEntityManager()) {
            manager.getTransaction().begin();
            Object objectInsideContext = manager.merge(object);
            manager.remove(objectInsideContext);
            manager.getTransaction().commit();

        }
    }

    public List<Cossos> tornaCossos(){
        List<Cossos> cossos;
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia); EntityManager manager = factory.createEntityManager()) {
            cossos = manager.createQuery("SELECT c FROM Cossos c", Cossos.class).getResultList();
        }
        return cossos;
    }

    public List<Cossos> tornaCossosNamedQuery(){
        List<Cossos> cossos;
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia); EntityManager manager = factory.createEntityManager()) {
            cossos = manager.createNamedQuery("Cossos.tots", Cossos.class).getResultList();
        }
        return cossos;
    }

    public List<Centre> tornaCentresLocalitat(Localitat localitat){
        List<Centre> centres;
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia); EntityManager manager = factory.createEntityManager()) {
            return factory.createEntityManager()
                    .createQuery("SELECT c FROM Centre c WHERE c.localitat = :localitat", Centre.class)
                    .setParameter("localitat", localitat)
                    .getResultList();
        }
    }

    // JPA PER ENTRENAR



}
