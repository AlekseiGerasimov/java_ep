package spring;

import objects.Car;
import objects.Product;
import objects.ProductsToUsers;
import objects.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/user")
    public List<String> user() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        List<String> resultList = new ArrayList<>();
        try(Session session = factory.openSession()){
            session.beginTransaction();
            List<User> listUsers = session.createQuery("from User").list();
            for(User user : listUsers){
                resultList.add(user.getUserName());
            }
            session.getTransaction().commit();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            factory.close();
        }
        return resultList;
    }

    @RequestMapping("/product")
    public List<String> product() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        List<String> resultList = new ArrayList<>();
        try(Session session = factory.openSession()){
            session.beginTransaction();
            List<Product> listProducts = session.createQuery("from Product").list();
            for(Product product : listProducts){
                resultList.add(product.getProductName() + " " + product.getProductPrice());
            }
            session.getTransaction().commit();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            factory.close();
        }
        return resultList;
    }

    @RequestMapping("/orders")
    public List<String> orders() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Map<String,List<Product>> userProductMap = new HashMap<>();
        List<String> resultList = new ArrayList<>();
        try(Session session = factory.openSession()){
            session.beginTransaction();
            List<ProductsToUsers> listProductsToUsers = session.createQuery("from ProductsToUsers").list();
            listProductsToUsers.forEach(userProduct->userProductMap.put(userProduct.getUserName(),userProduct.getPositions()));
            for(Map.Entry entry : userProductMap.entrySet()){
                StringBuilder nameUser = new StringBuilder();
                nameUser.append((String)entry.getKey());
                nameUser.append(": ");
                List<Product> productList = (List<Product>)entry.getValue();
                if(productList.size() == 0){
                    resultList.add(entry.getKey() + ": нет товаров для покупки;");
                    continue;
                }
                for(Product product : productList)
                     nameUser.append(product.getProductName().concat(" ").concat(String.valueOf(product.getProductPrice())).concat(";"));
                resultList.add(nameUser.toString());
            }
            session.getTransaction().commit();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            factory.close();
        }
        return resultList;
    }

    @RequestMapping("/test")
    public List<String> listCar() {
        List<String> resultSet = new ArrayList<>();
        SessionFactory factory = new Configuration().configure("other/hibernate.cfg.test.xml").buildSessionFactory();

        try(Session session = factory.openSession()){
            session.beginTransaction();
            List<Car> cars = (List<Car>)session.createQuery("from Car").list();
            for(Car car : cars)
                resultSet.add(car.getId() + " " + car.getModel() + " " + car.getColor() + " " +
                        car.getModelType() + " " + car.getCost());
            session.getTransaction().commit();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            factory.close();
        }
        return resultSet;
    }


    @RequestMapping("/test-list")
    public String addCar() {

        ApplicationContext context = new ClassPathXmlApplicationContext("other/context.xml");
        Car car = (Car)context.getBean("Car");
        System.out.println(car.getColor());
        SessionFactory factory = new Configuration().configure("other/hibernate.cfg.test.xml").buildSessionFactory();
        try(Session session = factory.openSession()){
            Transaction tr = session.beginTransaction();
            session.save(car);
            tr.commit();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            factory.close();
        }
        return "Модель добавлена";
    }

}
