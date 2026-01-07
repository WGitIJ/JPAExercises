//
//import model.Centre;
//import model.EspecialitatPK;
//import model.Especialitat;
//import model.Illa;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import test.ProvesJPA;
//
//
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class MainDemo {
//    public static void main(String[] args) {
//        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
//
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("interins-pu");
//        EntityManager manager = factory.createEntityManager();
//
//        try (factory; manager){
//            Illa mallorca=manager.find(Illa.class,"071");
//            System.out.println("mallorca = " + mallorca);
//            Especialitat informatica=manager.find(Especialitat.class,new EspecialitatPK("0590","107"));
//            System.out.println("informatica = " + informatica);
//
//            Centre centre=manager.find(Centre.class,"07000029");
//            System.out.println("centre = " + centre);
//
//            ProvesJPA provesJPA = new ProvesJPA("interins-pu");
//        }
//    }
//}
