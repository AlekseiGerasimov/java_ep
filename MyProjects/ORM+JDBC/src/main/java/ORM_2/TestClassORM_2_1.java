package ORM_2;

import DAO.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestClassORM_2_1 {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try {
            factory = new Configuration().configure("hibernate.cfg_1.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        TestClassORM_2_1 ME = new TestClassORM_2_1();
        ME.addEmployee(10,"kolo");
    }

    public void addEmployee(int id,String values){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            User employee = new User(id,values);
            session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
