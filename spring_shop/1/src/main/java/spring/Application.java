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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/user")
    public List<String> user() {
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
        return resultList;
    }

    @RequestMapping("/product")
    public List<String> product() {
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
        return resultList;
    }

    @RequestMapping("/orders")
    public List<String> orders() {
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
        return resultList;
    }
}
