
import ma.projet.model.Client;
import ma.projet.model.*;
import ma.projet.service.ClientService;

/**
 *
 * @author X1 YOGA
 */
public class Test {
    public static void main(String[] args) {
        ClientService cs = new ClientService();
        cs.create(new Client("fadwa","EE883232",8));
        cs.create(new Client("AMAL","GG883232",1));

        //cs.delete(cs.findById(1));

        System.out.println(cs.findAll());
    }
}
