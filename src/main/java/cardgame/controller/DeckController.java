package cardgame.controller;

import cardgame.bean.Card;
import cardgame.bean.Deck;
import cardgame.bean.User;
import cardgame.service.CardService;
import cardgame.service.DeckService;
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
@RequestMapping("/deck")
public class DeckController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CollectionController.class);

    @Autowired
    private CardService cardService;

    @Autowired
    private DeckService deckService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/leaderCards", method = RequestMethod.POST)
    public List<Card> leaderCards() {
        List<Card> leadersCards = new ArrayList<>();
        try {
            leadersCards = cardService.getCardLeaderKit();
        } catch (Exception exception) {
            LOGGER.error("Error getting leader cards");
            exception.printStackTrace();
        }
        return leadersCards;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Deck createNewDeck(@RequestBody String request) {
        Deck deck = new Deck();
        try {
            request = new String(request.getBytes("UTF-8"));
            ObjectMapper objectMapper = new ObjectMapper();
            deck = objectMapper.readValue(request, Deck.class);
            User user = userService.getUserByEmail(deck.getUser());
            Card leader = cardService.getCardById(deck.getLeader());
            deck.setUser(user);
            deck.setLeader(leader);
            deck.setActive(true);
            deck = deckService.createDeck(deck);
        } catch (Exception exception) {
            LOGGER.error("Error during deck create process");
            exception.printStackTrace();
        }
        return deck;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<Deck> usersDecks(@RequestBody String request) {
        List<Deck> decks = new ArrayList<>();
        try {
            request = new String(request.getBytes("UTF-8"));
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.readValue(request, User.class);
            decks = deckService.getUserDecks(userService.getUserByEmail(user));
        } catch (Exception exception) {
            LOGGER.error("Error getting user decks");
            exception.printStackTrace();
        }
        return decks;
    }

    @RequestMapping(value = "/editDeck", method = RequestMethod.POST)
    public Deck editUserDeck(@RequestBody String request) {
        Deck deck = new Deck();
        try {
            request = new String(request.getBytes("UTF-8"));
            ObjectMapper objectMapper = new ObjectMapper();
            Deck requestDeck = objectMapper.readValue(request, Deck.class);
            User user = userService.getUserByEmail(requestDeck.getUser());
            deck = deckService.getUserDeck(user, requestDeck);
            List<Card> cards = cardService.getCardListFromDeck(requestDeck.getCards());
            deck.setCards(cards);
            deckService.editDeck(deck);
        } catch (Exception exception) {
            LOGGER.error("Error during editing deck data");
            exception.printStackTrace();
        }
        return deck;
    }
}
