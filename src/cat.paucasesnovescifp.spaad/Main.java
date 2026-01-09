import JPA.model.Aspirant;
import JPA.model.Illa;
import JPA.model.Localitat;
import JPA.model.Preferencies;
import JPA.test.ProvesJPA;
import DAO.help.internisDAOimpl;

import java.util.List;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);
        ProvesJPA provesJPA = new ProvesJPA("interins-pu");
        internisDAOimpl internisDAOimpl = new internisDAOimpl("interins-pu");
//        provesJPA.modifcaAdrecaAspirant("12007493F", "Calle 123");
        Illa illa = new Illa("071", "Mallorca");
        Localitat localitat = new Localitat("070270001",illa, "Inca");
//        Centre centre = new Centre("07007841", "CIFP PAU CASESNOVES", localitat);
//        provesJPA.actualitzaCentre(centre);

//        Centre centre = provesJPA.creaCentra("99999", "IES INCA", localitat);
//        System.out.println(centre);

//        Centre centre = new Centre("99999", "IES INCA",localitat);
//        provesJPA.esborra(centre);

//        provesJPA.tornaCentresLocalitat(localitat).forEach(System.out::println);
//        List<Illa> illes = internisDAOimpl.tornaIlles();
//        illes.forEach(System.out::println);

//        List<Localitat> localitats = internisDAOimpl.tornaLocalitatsIllesNamedQuery(illa);
//        localitats.forEach(System.out::println);

//        List<Aspirant> aspirantes = internisDAOimpl.tornaAspirants(1, 5);
//        aspirantes.forEach(System.out::println);

//        List<String> nifs = internisDAOimpl.getNifs(1,10);
//        nifs.forEach(System.out::println);

//        List<String> nomsComplets = internisDAOimpl.getNomComplet(1,3);
//        nomsComplets.forEach(System.out::println);

//        List<Localitat> localitats1 = internisDAOimpl.tornaLocalitatsIlla2(illa);
//        localitats1.forEach(System.out::println);

        List<Preferencies> preferencies = internisDAOimpl.getPreferences(1,3);
        preferencies.forEach(System.out::println);

    }
}
