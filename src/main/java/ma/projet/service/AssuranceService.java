package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.model.Assurance;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ma.projet.util.HebernateUtil;

public class AssuranceService implements IDao<Assurance> {

    @Override
    public boolean create(Assurance t) {
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
    public boolean update(Assurance t) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HebernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(t);
            tx.commit();
            etat = true;

        }catch (HibernateException e) {
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
    public boolean delete(Assurance t) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HebernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
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
    public Assurance findById(int id) {
        Session session = null;
        Transaction tx = null;
        Assurance assurance = null;
        try {
            session = HebernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            assurance = (Assurance) session.get(Assurance.class, id);
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
        return assurance;
    }


    @Override
    public List<Assurance> findAll() {
     Session session = null;
     Transaction tx = null;
     boolean etat = false;
     List<Assurance> assurances = null;
     try {
            session = HebernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            assurances = session.createQuery("from Assurance").list();
            tx.commit();

     }catch (HibernateException e) {
         if (tx != null) {
             tx.rollback();

         }
     }finally {
         if (session != null) {
             session.close();
         }

     }
     return assurances;
    }
}
