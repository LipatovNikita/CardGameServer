package cardgame;

import cardgame.bean.Card;
import cardgame.bean.User;
import cardgame.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardgameApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
    }

/*    @Test
    public void java_map_to_json() throws JsonProcessingException {
        Map<Card, Integer> map = new LinkedHashMap<>();
        map.put(new Card() {{
            setName("Говно");
        }}, 1);
        map.put(new Card() {{
            setName("Жопа");
        }}, 2);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(map);
        System.err.print(json);
    }*/

    /*@Test
    public void getCardsByUser() {
        User user = new User();
        Map<Card, Integer> userCards = new HashMap<>();
        user.setEmail("nikita@mail.ru");
        User findUser = userService.getUserByEmail(user);
        System.out.print(findUser.toString());
    }*/
}
