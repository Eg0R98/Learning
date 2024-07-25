package NumbersProperty;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static Map<String, StringBuilder> map = new HashMap<>();

    public static void add(String numberFact, StringBuilder response) {
        map.put(numberFact, response);
    }

    public static StringBuilder searchAndGet(String key) {
        for (String s : map.keySet()) {
            if (s.equals(key)) return map.get(s);
        }
        return null;
    }
}
