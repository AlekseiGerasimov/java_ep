package ORM_1;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.List;

public class TestClass{
    private static SessionFactory factory;
    public static void main(String[] args) {
        try {
            factory = new Configuration().configure(new File("C:\\Users\\Aleksey\\Desktop\\hibernate\\1\\hibernate.cfg.xml")).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        TestClass test = new TestClass();
//        test.addTest(1001,"John");
//        test.addTest(1201,"Kate");
        test.listTest();
    }

    public void addTest(int id,String name){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            First employee = new First(id,name);
            session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void listTest( ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List list = session.createQuery("from ORM_1.First").list();
            for (Object j : list){
                First f = (First)j;
                System.out.println(f.getId() + " " + f.getName());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
