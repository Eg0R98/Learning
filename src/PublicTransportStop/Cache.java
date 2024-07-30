package PublicTransportStop;

import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static Map<Integer, Document> cacheMap = new HashMap<>();

    public static void add(int stopID, Document response) {
        cacheMap.put(stopID, response);
    }

    public static Document searchAndGet(int key) {
        if (cacheMap.containsKey(key)) return cacheMap.get(key);
        return null;
    }

    public static Map<Integer, Document> getCacheMap() {
        return cacheMap;
    }

    public static void setCacheMap(Map<Integer, Document> cacheMap) {
        Cache.cacheMap = cacheMap;
    }
}

