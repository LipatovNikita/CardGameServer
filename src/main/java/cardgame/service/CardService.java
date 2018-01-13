package cardgame.service;


import cardgame.bean.Card;

import java.util.List;

public interface CardService {
    List<Card> getCardInitialKit();
    List<Card> getCardLeaderKit();
    List<Card> getCardList();
    Card getCardById(Card card);
    List<Card> getCardListFromDeck(List<Card> cards);
}
