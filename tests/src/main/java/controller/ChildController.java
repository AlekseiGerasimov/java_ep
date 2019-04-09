package controller;

import entity.Child;
import entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ChildService;
import service.ParentService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/child")
public class ChildController {

    private final ChildService childService;

    private final ParentService parentService;

    @Autowired
    public ChildController(ChildService childService, ParentService parentService) {
        this.childService = childService;
        this.parentService = parentService;
    }

    @RequestMapping("/get")
    public String getParents() {
        return childService.getChilds().stream()
                .map(parent ->
                        parent.getId() + parent.getName())
                .collect(Collectors.joining("----"));
    }

}
