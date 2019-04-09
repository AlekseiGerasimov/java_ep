package controller;

import entity.Child;
import entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ParentService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @RequestMapping("/get")
    public String getParents() {
        List<Parent> parentList = parentService.getParents();
        return parentList.stream()
                .map(parent ->{
                    StringBuilder builder = new StringBuilder();
                    for(Map.Entry entry : parent.getLongMap().entrySet()){
                        builder.append(entry.getKey() + " " + entry.getValue());
                    }
                   return builder.toString();
    })
                .collect(Collectors.joining("----"));
    }

    @RequestMapping("/add/{name}")
    public String getParents(@PathVariable("name") String name) {
        return parentService.addParent(name).getName();
    }

}
