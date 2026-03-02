package ma.projet.Test;




import ma.projet.model.Contrat;
import ma.projet.model.Client;
import ma.projet.service.ContratService;
import ma.projet.service.ClientService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author X1 YOGA
 */
public class TestClient {

    public static void main(String[] args) {
        ClientService ss = new ClientService();
        ContratService es = new ContratService();

        ss.create(new Client("ali"," 22gg",7));
        ss.create(new Client("alae"," 22ggg",1));

        Contrat e = es.findById(1);
        e.getContrat().add(ss.findById(1));
        e.getContrat().add(ss.findById(2));
        es.update(e);



    }

}

