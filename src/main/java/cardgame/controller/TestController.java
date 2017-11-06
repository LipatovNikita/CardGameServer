package cardgame.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/", ""})
public class TestController {

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String registrationUser(/*@RequestBody User user*/) {
        System.err.println("Hello, logs!");
        return "sdfdgdgevd";
    }
}
