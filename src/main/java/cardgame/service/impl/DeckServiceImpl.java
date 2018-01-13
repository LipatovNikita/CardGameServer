package cardgame.service.impl;

import cardgame.bean.Deck;
import cardgame.bean.User;
import cardgame.repository.DeckRepository;
import cardgame.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Override
    public Deck createDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    @Override
    public Deck editDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    @Override
    public List<Deck> getUserDecks(User user) {
        return deckRepository.findDecksByUser(user);
    }

    @Override
    public Deck getUserDeck(User user, Deck deck) {
        return deckRepository.findDeckByUserAndName(user, deck.getName());
    }
}
