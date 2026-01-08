package DAO.help;

import JPA.model.Aspirant;
import JPA.model.Illa;
import JPA.model.Localitat;
import jakarta.persistence.*;

import java.sql.Struct;
import java.util.List;
import java.util.prefs.Preferences;

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

    //TODO tornaIlles(): Torna una llista amb totes totes les illes de la base de dades. Crea una consulta dinàmica per fer-ho.
    @Override
    public List<Illa> tornaIlles() {
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager manager = factory.createEntityManager()){
            TypedQuery<Illa> query = manager.createQuery("from Illa", Illa.class);
            List<Illa> illes = query.getResultList();
            return illes;
        }
    }

    //TODO Repeteix l'exercici anterior però utilitzant una Named Query.
    @Override
    public List<Illa> tornaIllesNamedQuery() {
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia);
            EntityManager manager = factory.createEntityManager()){
            TypedQuery<Illa> query = manager.createNamedQuery("tornaIlles", Illa.class);
            List<Illa> illes = query.getResultList();
            return illes;
        }
    }

    //TODO tornaLocalitatsIlla(Illa illa): crea una consulta dinàmica que torni totes les localitats d'una illa determinada.
    @Override
    public List<Localitat> tornaLocalitatsIlla(Illa illa) {
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia);
            EntityManager manager = factory.createEntityManager()){
            TypedQuery<Localitat> query = manager.createQuery("Select l from Localitat l where l.illa = :illaParam", Localitat.class);
            query.setParameter("illaParam", illa);
            List<Localitat> localitats = query.getResultList();
            return localitats;
        }
    }

    //TODO Repeteix l'exercici anterior sense utilitzar consultes?

    //TODO Crea una namedQuery a la classe que toqui per tornar totes les localitats d'una determinada illa i implementa un mètode per utilitzar-la.
    @Override
    public List<Localitat> tornaLocalitatsIllesNamedQuery(Illa illa) {
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia);
            EntityManager manager = factory.createEntityManager()){
            TypedQuery<Localitat> query = manager.createNamedQuery("tornaLocalitatsIlla", Localitat.class);
            query.setParameter("illa", illa);
            List<Localitat> localitats = query.getResultList();
            return localitats;
        }
    }

    //TODO tornaAspirants(int inici, int quantitat): torna tants aspirants (ordenats per llinatges) com indiqui quantitat començant per la posició que indica inici.
    @Override
    public List<Aspirant> tornaAspirants(int inici, int quantitat) {
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager manager = factory.createEntityManager()){
            TypedQuery<Aspirant> query = manager.createQuery("from Aspirant order by llinatges", Aspirant.class);
            query.setFirstResult(inici);
            query.setMaxResults(quantitat);
            List<Aspirant> aspirants = query.getResultList();
            return aspirants;
        }
    }

    //TODO getNifs(int inici, int quantitat): Torna una llista que conté només els nifs dels aspirants (ordenats per llinatges) de la base de dades. Utilitza una NamedQuery.
    @Override
    public List<String> getNifs(int inici, int quantitat) {
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager manager = factory.createEntityManager()){
            TypedQuery<String> query = manager.createNamedQuery("getNifs",String.class);
            query.setFirstResult(inici);
            query.setMaxResults(quantitat);
            return query.getResultList();
        }
    }
    //TODO getNomComplet(int inici, int quantitat):Torna només el nom i els llinatges dels aspirants (ordenats per llinatges i nom). No pots utilitzar una TypedQuery.
    @Override
    public List<String> getNomComplet(int inici, int quanitat) {
        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia);
        EntityManager manager = factory.createEntityManager()){
            Query query = manager.createQuery("SELECT CONCAT(a.nom, ' ', a.llinatges) FROM Aspirant a ORDER BY a.llinatges, a.nom");
            query.setFirstResult(inici);
            query.setMaxResults(quanitat);
            List<String> nomsComplets = query.getResultList();
            return nomsComplets;
        }
    }

    //TODO getPreferencies(int inici, int quantitat): Torna les preferències de la base de dades ordenades per id de centre.
    //!! Mi clase Preferencies no está implementada correctamente en JPA, por lo que no puedo completar este método.
    @Override
    public Preferences getPreferences(int inici, int quantitat) {
//        try(EntityManagerFactory factory = Persistence.createEntityManagerFactory(unitatPersistencia);
//        EntityManager manager = factory.createEntityManager()){
//
//        }
    }


}
