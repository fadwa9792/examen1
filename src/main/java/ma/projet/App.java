package ma.projet;

//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

import ma.projet.model.Client;
import ma.projet.model.Contrat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("evaluation1");
        Client c = new Client();
        c.setId( 2 );

    c.create(new Client(2,"b55565", "Nassiri", "fadwa"));

    }
}
