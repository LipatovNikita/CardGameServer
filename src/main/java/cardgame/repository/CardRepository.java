package cardgame.repository;

import cardgame.bean.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {

    @Query("SELECT card FROM Card card WHERE card.id IN :cardGuids")
    List<Card> findCardsByGuids(@Param("cardGuids") String[] cardGuids);
}
