package DB.Worker;

import DB.interfaces.Iworker;
import Objects.Position;
import Objects.Worker;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class WorkerDB implements Iworker {
    private SessionFactory factory = null;

    public WorkerDB() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void listPerson() {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            List<Worker> list = session.createQuery("from Worker").list();
            for(Worker worker : list){
                System.out.print(worker.getId() + " " + worker.getName() + " " + worker.getMale() + ":");
                for(Position position : worker.getPositions()){
                    System.out.print(" "+ position.getName_pos());
                    System.out.print(";");
                }
                System.out.println();
            }
            session.getTransaction().commit();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void addPerson(Worker worker) {
        try(Session session = factory.openSession()){
           session.beginTransaction();
           session.save(worker);
           session.getTransaction().commit();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void removePerson(int id_worker) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            Worker worker = session.get(Worker.class,id_worker);
            session.remove(worker);
            session.getTransaction().commit();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updatePerson(int id,String name,String male) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            Worker worker = session.get(Worker.class,id);
            worker.setName(name);
            worker.setMale(male);
            session.update(worker);
            session.getTransaction().commit();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
    }
}
