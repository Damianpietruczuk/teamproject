package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateDao {

    public void saveHibernateEntity(HibernateEntity hibernateEntity) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(hibernateEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateHibernateEntity(HibernateEntity hibernateEntity) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(hibernateEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteHibernateEntity(HibernateEntity hibernateEntity) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hibernateEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Employees> getEmployees() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Employees", Employees.class).list();
        }
    }

    public List<Phones> getPhones() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Phones", Phones.class).list();
        }
    }

    public List<Printer> getPrinters() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Printer", Printer.class).list();
        }
    }

    public List<Printer> getCars() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Cars", Printer.class).list();
        }
    }
}
