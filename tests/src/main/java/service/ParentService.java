package service;

import entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ParentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public List<Parent> getParents(){
        final List<Parent> list = new ArrayList<Parent>();
        parentRepository.findAll().forEach(element -> list.add(element));
        return list;
    }

    public Parent addParent(String name){
        Parent parent = new Parent(name);
        parentRepository.save(parent);
        return parent;
    }

    public void save(Parent parent){
        parentRepository.save(parent);
    }
}
