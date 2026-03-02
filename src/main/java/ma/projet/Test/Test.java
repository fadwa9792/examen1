package ma.projet.Test;

import ma.projet.model.Assurance;
import ma.projet.model.Client;
import ma.projet.model.Contrat;
import ma.projet.util.HebernateUtil;

import org.hibernate.Hibernate;
import org.hibernate.Session;

public class Test {
    public static void main(String[] args) {

        Session session= HebernateUtil.getSessionFactory().openSession();



    }
}