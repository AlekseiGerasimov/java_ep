package service;

import objects.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepositoryHandler {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    public List<String> listProducts(){
        List<String> productList = new ArrayList<>();
        productRepository.findAll().forEach(product->productList.add(product.getProductName() + ": " + product.getCost()));
        return productList;
    }


    public List<String> listUsers(){
        List<String> userList = new ArrayList<>();
        userRepository.findAll().forEach(user->userList.add(user.getUserName()));
        return userList;
    }

    public List<String> listOrders(){
        List<String> userList = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            userList.add(user.getUserName() + ": " + user.getProductList().size());
        });
        return userList;
    }

}
