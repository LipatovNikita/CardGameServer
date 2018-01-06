package cardgame.repository;

import cardgame.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmailAndIsActive(String email, boolean isActive);
}
