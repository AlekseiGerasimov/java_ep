package spring;

import objects.Product;
import objects.ProductsToUsers;
import objects.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/user")
    public List<String> user() {
        return getUser();
    }

    @RequestMapping("/product")
    public List<String> product() {
        return getProduct();
    }

    @RequestMapping("/orders")
    public List<String> orders() {
        return getProductsToUser();
    }

    public List<String> getUser(){
        List<String> resultList = new ArrayList<>();
        SessionFactory factory = new Configuration().configure("hibernate.cfg.user.xml").buildSessionFactory();
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
        return resultList;
    }

    public List<String> getProduct(){
        List<String> resultList = new ArrayList<>();
        SessionFactory factory = new Configuration().configure("hibernate.cfg.product.xml").buildSessionFactory();
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
        return resultList;
    }

    public List<String> getProductsToUser(){
        final List<String> resultList = new ArrayList<>();
        SessionFactory factory = new Configuration().configure("hibernate.cfg.product_to_users.xml").buildSessionFactory();
        try(Session session = factory.openSession()){
            session.beginTransaction();
            List<ProductsToUsers> listProductsToUsers = session.createQuery("from ProductsToUsers").list();
            for(ProductsToUsers productstousers : listProductsToUsers){
                String position = productstousers.getUserName();
                productstousers.getPositions().forEach(a->position.concat(a.getProductName().concat(" ")));
                resultList.add(position);
            }
            session.getTransaction().commit();
        }
        catch(HibernateException ex){
            ex.printStackTrace();
        }
        return resultList;
    }
}
