package cardgame.bean;

import lombok.Data;

import java.util.Map;

@Data
public class Collection {
    private Map<Card, Integer> data;
}
