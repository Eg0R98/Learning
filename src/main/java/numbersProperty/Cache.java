package numbersProperty;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static long timeUpdate = 120;

    private static Map<String, CacheItem> cacheMap = new HashMap<>();

    public static void add(String numFact, String response) {
        cacheMap.put(numFact, new CacheItem(response));
    }

    public static String searchAndGet(String numFact) throws IOException {
        if (cacheMap.containsKey(numFact)) {
            CacheItem cacheItem = cacheMap.get(numFact);
            boolean updateOrNot = Cache.updateOrNot(numFact);
            if (updateOrNot) return null;
            return cacheItem.getDocumentStr();
        }
        return null;
    }

    private static boolean updateOrNot(String numFact) {
        CacheItem cacheItem = cacheMap.get(numFact);
        long timeDifference = Instant.now().getEpochSecond() - cacheItem.getInstantStart().getEpochSecond();
        return timeDifference > timeUpdate;
    }

    public static void save() {
        try {
            SaveLoad.writeToFile(cacheMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void load() throws IOException {
        cacheMap = SaveLoad.readFromFile();
    }

}

