package cardgame.controller;

import cardgame.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationUser(@RequestBody String request) {
        System.err.println(request);
        return "test";
    }
}
