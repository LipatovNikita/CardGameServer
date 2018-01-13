package cardgame.service;


import cardgame.bean.Deck;
import cardgame.bean.User;

import java.util.List;

public interface DeckService {
    Deck createDeck(Deck deck);
    Deck editDeck(Deck deck);
    List<Deck> getUserDecks(User user);
    Deck getUserDeck(User user, Deck deck);
}
