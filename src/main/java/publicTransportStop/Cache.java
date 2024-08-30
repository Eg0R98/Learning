package publicTransportStop;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static long timeUpdate = 30;
    private static Map<Integer, CacheItem> cacheMap = new HashMap<>();

    public static void add(int stopNumber, String response) {
        cacheMap.put(stopNumber, new CacheItem(response));
    }

    public static String searchAndGet(int stopNumber) {
        if (cacheMap.containsKey(stopNumber)) {
            CacheItem cacheItem = cacheMap.get(stopNumber);
            if (Cache.updateOrNot(cacheItem)) return null;
            return cacheItem.getDocumentStr();
        }
        return null;
    }

    private static boolean updateOrNot(CacheItem cacheItem) {
        long timeDifference = Instant.now().getEpochSecond() - cacheItem.getInstantStart().getEpochSecond();
        return timeDifference > timeUpdate;
    }

}

