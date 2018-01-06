package cardgame.service.impl;


import cardgame.bean.Card;
import cardgame.repository.CardRepository;
import cardgame.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        };
        return cardRepository.findCardsByGuids(cardGuids);
    }

    @Override
    public List<Card> getCardList() {
        return cardRepository.findAll();
    }
}
