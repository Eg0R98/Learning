package NumbersProperty;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static Map<String, String> cacheMap = new HashMap<>();

    public static void add(String numberFact, String response) {
        cacheMap.put(numberFact, response);
    }

    public static String searchAndGet(String key) {
        if (cacheMap.containsKey(key)) return cacheMap.get(key);
        return null;
    }

    public static Map<String, String> getCacheMap() {
        return cacheMap;
    }

    public static void setCacheMap(Map<String, String> cacheMap) {
        Cache.cacheMap = cacheMap;
    }
}
