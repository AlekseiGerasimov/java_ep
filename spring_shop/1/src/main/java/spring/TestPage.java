package spring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class TestPage {
    @RequestMapping(value="/{user}", method = RequestMethod.GET)
    public String getUser(@PathVariable String user) {
       return "Привет " + user;
    }
}
