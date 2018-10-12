package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.RepositoryHandler;

import java.util.List;

@Controller
public class MainAppController {

    @Autowired
    RepositoryHandler repositoryHandler;


    @GetMapping("/users")
    @ResponseBody
    public List<String> users(){
        return repositoryHandler.listUsers();
    }

    @GetMapping("/products")
    @ResponseBody
    public List<String> products(){
        return repositoryHandler.listProducts();
    }


    @GetMapping("/orders")
    @ResponseBody
    public List<String> orders(){
        return repositoryHandler.listOrders();
    }

}
