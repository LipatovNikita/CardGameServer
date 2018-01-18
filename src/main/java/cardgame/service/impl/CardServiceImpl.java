package cardgame.service.impl;


import cardgame.bean.Card;
import cardgame.bean.User;
import cardgame.repository.CardRepository;
import cardgame.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> getCardInitialKit() {
        String[] cardGuids = {
                "022bb5cc-5370-49e1-a5b9-44e2a1ac0bc5",
                "4f62b19b-9071-484a-b95b-4a75c165c8e5",
                "82b6388a-04ae-46fd-ba81-ff2bf1ce4421",
                "9cd82b91-bee7-430c-a3e3-da0fd5eea212",
                "f6cb6287-fd9a-4221-b27f-e4fe9415da1f",
                "49c994b4-57ec-45cc-9c2e-df10f7174684",
                "5fe25eaf-2980-4bdb-b43f-d9a2fb913a2e",
                "62d9092b-60b9-48b5-ba3b-9a95788d82eb",
                "74182825-5d33-480c-929b-836f25fbafb8",
                "75222a8e-9630-4074-97f8-701f1addf2b4",
                "806e2d08-aa1a-4fad-87cb-b86c5699534d",
                "8ed68719-a0a6-4f8d-92ed-790328406b1d",
                "c1f2408a-a2ee-419b-baf5-18aeb4ee615c",
                "daa41aa9-af6c-4e9c-990e-21f7200df0ef"
        };
        return cardRepository.findCardsByGuids(cardGuids);
    }

    @Override
    public List<Card> getCardLeaderKit() {
        return cardRepository.findCardsByIsLeaderAndIsActive(true, true);
    }

    @Override
    public List<Card> getCardList() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCardById(Card card) {
        return cardRepository.findOne(card.getId());
    }

    @Override
    public List<Card> getCardListFromDeck(List<Card> cards) {
        List<Card> findCards = new ArrayList<>();
        for (Card card : cards) {
            findCards.add(cardRepository.findOne(card.getId()));
        }
        return findCards;
    }
}
