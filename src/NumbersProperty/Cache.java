package NumbersProperty;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static Map<String, StringBuilder> map = new HashMap<>();
    public static void add(String numberFact, StringBuilder response) {
        map.put(numberFact, response);
    }

    public static String searchAndGet(String key) {
        if (map.containsKey(key)) return map.get(key).toString();
        return null;
    }
}
