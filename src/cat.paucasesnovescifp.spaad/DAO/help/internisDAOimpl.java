package DAO.help;

import JPA.model.Aspirant;
import JPA.model.Illa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class internisDAOimpl implements interinsDAO {
    private String unitatPersistencia;

    public internisDAOimpl(String unitatPersistencia) {
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
    @Override
    public Aspirant recuperarAspirant(String nif){
        Aspirant aspirant;
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia); EntityManager manager = factory.createEntityManager()) {
            aspirant = manager.find(Aspirant.class, nif);
        }
        return aspirant;
    }
    @Override
    public void modificarLlinatge(String llinatge, String nif){
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia); EntityManager manager = factory.createEntityManager()) {
            manager.getTransaction().begin();
            Aspirant aspirant = recuperarAspirant(nif);
            aspirant.setLlinatges(llinatge);
            manager.getTransaction().commit();
        }
    }
    @Override
    public void actualitzaAspirant(Aspirant aspirant){
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia); EntityManager manager = factory.createEntityManager()) {
            manager.getTransaction().begin();
            manager.merge(aspirant);
            manager.getTransaction().commit();
        }
    }
    @Override
    public void crearAspirant(Aspirant aspirant){
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia);
            EntityManager manager = factory.createEntityManager()){
            manager.getTransaction().begin();
            manager.persist(aspirant);
            manager.getTransaction().commit();
        }
    }

    @Override
    public void crearObjecte(Object object){
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia);
            EntityManager manager = factory.createEntityManager()){
            manager.getTransaction().begin();
            manager.persist(object  );
            manager.getTransaction().commit();
        }
    }
    @Override
    public void updateObject(Object object){
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia);
            EntityManager manager = factory.createEntityManager()){
            manager.getTransaction().begin();
            Object object_merged = manager.merge(object);
            manager.merge(object);
            manager.getTransaction().commit();
        }
    }
    @Override
    public void deleteObject(Object object){
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia);
            EntityManager manager = factory.createEntityManager()){
            manager.getTransaction().begin();
            Object object_merged = manager.merge(object);
            manager.remove(object_merged);
            manager.getTransaction().commit();
        }
    }

    @Override
    public List<Illa> tornaIlles() {
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager manager = factory.createEntityManager()){
            TypedQuery<Illa> query = manager.createQuery("from Illa", Illa.class);
            List<Illa> illes = query.getResultList();
            return illes;
        }
    }
}
