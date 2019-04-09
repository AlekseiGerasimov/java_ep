package service;

import entity.Child;
import entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ChildRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChildService {
    @Autowired
    private ChildRepository childRepository;

    public List<Child> getChilds(){
        final List<Child> list = new ArrayList<Child>();
        childRepository.findAll().forEach(element -> list.add(element));
        return list;
    }
}
