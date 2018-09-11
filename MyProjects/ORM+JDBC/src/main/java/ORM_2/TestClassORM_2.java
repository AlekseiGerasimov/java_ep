package ORM_2;

import DAO.Person;
import DAO.Person_ant;
import DAO.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class TestClassORM_2 {
    public static void main(String[] args) {
        TestClassORM_2 test = new TestClassORM_2();
//        User user = new User("Volodya");
//        test.addUser(user);
        test.listUsers();

//        System.out.println();
//
//        test.deleteUser(user);
//        test.listUsers();

    }

    public void addUser(User user){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void listUsers(){
        SessionFactory factory = new Configuration().configure("hibernate.cfg_ant.xml").buildSessionFactory();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            List<Person_ant> list = session.createQuery("from Person_ant").list();
            for(Person_ant person : list){
                Hibernate.initialize(person.getUser());
                System.out.println(person.getId() + " " + person.getPerson() + " " +person.getUser().getValues());
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        try(Session session = factory.openSession()){
            session.beginTransaction();
            User user1 = session.get(User.class,user.getId());
            user1.setId(user.getId());
            user1.setValues(user.getValues());
            session.update(user1);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User user){
        SessionFactory factory =new Configuration().configure().buildSessionFactory();
        try(Session session = factory.openSession()){
            session.beginTransaction();
            User user1 = session.get(User.class,user.getId());
            session.delete(user1);
            session.getTransaction().commit();
        }catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}
