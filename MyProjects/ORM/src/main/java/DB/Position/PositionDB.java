package DB.Position;

import DB.interfaces.Iposition;
import Objects.Position;
import Objects.Worker;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PositionDB implements Iposition {
    private SessionFactory factory = null;

    public PositionDB() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void listPosition() {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            List<Position> list = session.createQuery("from Position").list();
            for(Position position : list){
                System.out.print(position.getId_pos() + " " + position.getName_pos() + ":");
                for(Worker worker : position.getWorkers()){
                    System.out.print(" "+ worker.getName() + " " + worker.getMale());
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
    public void addPosition(Position position) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(position);
            session.getTransaction().commit();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void removePosition(int id_position) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            Position position = session.get(Position.class,id_position);
            session.remove(position);
            session.getTransaction().commit();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updatePosition(int id_position, String name_pos) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            Position position = session.get(Position.class,id_position);
            position.setName_pos(name_pos);
            session.update(position);
            session.getTransaction().commit();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
    }
}
