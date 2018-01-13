package cardgame.repository;

import cardgame.bean.Deck;
import cardgame.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckRepository extends JpaRepository<Deck, String> {
    List<Deck> findDecksByUser(User user);
    Deck findDeckByUserAndName(User user, String name);
}
