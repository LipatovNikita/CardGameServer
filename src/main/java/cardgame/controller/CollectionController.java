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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CollectionController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/cards", method = RequestMethod.POST)
    public List<Card> allCards() {
        List<Card> cards = new ArrayList<>();
        try {
            cards = cardService.getCardList();
        } catch (Exception exception) {
            LOGGER.error("Error getting card collection");
            exception.printStackTrace();
        }
        return cards;
    }

    @RequestMapping(value = "/userCards", method = RequestMethod.POST)
    public List<Card> enableUserCards(@RequestBody String request) {
        List<Card> cards = new ArrayList<>();
        try {
            request = new String(request.getBytes("UTF-8"));
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.readValue(request, User.class);
            User findUser = userService.getUserByEmail(user);
            cards = findUser.getCards();
        } catch (Exception exception) {
            LOGGER.error("Error getting user card collection");
            exception.printStackTrace();
        }
        return cards;
    }
}
