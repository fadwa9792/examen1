package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.model.Client;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ma.projet.util.HebernateUtil;

public class ClientService implements IDao<Client>
{


    @Override
    public boolean create(Client t) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HebernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(t);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public boolean update(Client t) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HebernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(t);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();

            }

        }finally {
            if (session != null) {
                session.close();

            }

        }return etat;


    }

    @Override
    public boolean delete(Client client) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HebernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(client);
            tx.commit();
            etat = true;

        }
        catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();

            }
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;

    }

    @Override
    public Client findById(int id) {
        Session session = null;
        Transaction tx = null;
        Client client = null;
        try {
            session = HebernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            client = (Client) session.get(Client.class, id);
            tx.commit();

        }
        catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();

            }
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return client;
    }

    @Override
    public List<Client> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Client> clients = null;
        try {
            session = HebernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            clients = session.createQuery("from Client").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return clients;
    }
}
