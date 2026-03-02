package ma.projet;
import org.hibernate.Hibernate;
import ma.projet.service.AssuranceService;
import ma.projet.util.HebernateUtil;

public class TestAssurance {
    public static void main(String[] args) {
        AssuranceService as = new AssuranceService();
        System.out.println(as.findAll());


    }
}
