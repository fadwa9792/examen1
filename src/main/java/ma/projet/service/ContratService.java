package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.model.Contrat;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ma.projet.util.HebernateUtil;

public class ContratService implements IDao<Contrat>
{


    @Override
    public boolean create(Contrat t) {
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
    public boolean update(Contrat t) {
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
    public boolean delete(Contrat contrat) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HebernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(contrat);
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
    public Contrat findById(int id) {
        Session session = null;
        Transaction tx = null;
        Contrat contrat = null;
        try {
            session = HebernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            contrat = (Contrat) session.get(Contrat.class, id);
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
        return contrat;
    }

    @Override
    public List<Contrat> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Contrat> contrats = null;
        try {
            session = HebernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            contrats = session.createQuery("from Contrat").list();
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
        return contrats;
    }
    public List<Contrat> contratsPrixSuperieur100() {
        Session session = HebernateUtil.getSessionFactory().openSession();

        List<Contrat> contrats = session
                .createNamedQuery("Contrat.prixSuperieur100", Contrat.class)
                .list();

        session.close();
        return contrats;
    }
    public List<Contrat> findContratsByCategorie(Contrat contrat) {
        Session session = HebernateUtil.getSessionFactory().openSession();

        List<Contrat> contrats = session.createQuery(
                        "from Contrat p where p.categorie = :cat",
                        Contrat.class
                ).setParameter("cat", contrat)
                .list();

        session.close();
        return contrats;
    }
}
