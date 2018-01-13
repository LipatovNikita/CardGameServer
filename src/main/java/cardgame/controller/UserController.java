package cardgame.controller;

import cardgame.bean.Card;
import cardgame.bean.User;
import cardgame.service.CardService;
import cardgame.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public User registrationUser(@RequestBody String request) {
        User user = new User();
        try {
            request = new String(request.getBytes("UTF-8"));
            ObjectMapper objectMapper = new ObjectMapper();
            user = objectMapper.readValue(request, User.class);
            List<Card> cardInitialKit = cardService.getCardInitialKit();
            user.setCards(cardInitialKit);
            userService.registerUser(user);
        } catch (Exception exception) {
            LOGGER.error("Error during user registration process");
            exception.printStackTrace();
        }
        return user;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public User getUserData(@RequestBody String request) {
        User user = new User();
        try {
            request = new String(request.getBytes("UTF-8"));
            ObjectMapper objectMapper = new ObjectMapper();
            User userFromRequest = objectMapper.readValue(request, User.class);
            user = userService.getUserByEmail(userFromRequest);
            if (user == null) {
                throw new Exception();
            }
        } catch (Exception exception) {
            LOGGER.error("Error during getting user data");
            exception.printStackTrace();
        }
        return user;
    }

    @RequestMapping(value = "/editProfile", method = RequestMethod.POST)
    public User editUserProfile(@RequestBody String request) {
        User user = new User();
        try {
            request = new String(request.getBytes("UTF-8"));
            ObjectMapper objectMapper = new ObjectMapper();
            User userFromRequest = objectMapper.readValue(request, User.class);
            user = userService.getUserByEmail(userFromRequest);
            if (user != null) {
                user.setUsername(userFromRequest.getUsername());
                user = userService.editUser(user);
            } else {
                throw new Exception();
            }
        } catch (Exception exception) {
            LOGGER.error("Error during editing user data");
            exception.printStackTrace();
        }
        return user;
    }
}
