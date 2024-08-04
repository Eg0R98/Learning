package PublicTransportStop;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static Map<Integer, Cache> cacheMap = new HashMap<>();
    private static long timeUpdate = 30;
    private Instant instantStart;
    private String documentStr;

    private Cache(String documentStr) {
        this.instantStart = Instant.now();
        this.documentStr = documentStr;
    }

    public static void add(int stopID, String responce) {

        cacheMap.put(stopID, new Cache(responce));
    }

    public static String searchAndGet(int key) {
        if (cacheMap.containsKey(key)) return cacheMap.get(key).getDocumentStr();
        return null;
    }

    public static Map<Integer, Cache> getCacheMap() {
        return cacheMap;
    }

    public static void setCacheMap(Map<Integer, Cache> cacheMap) {
        Cache.cacheMap = cacheMap;
    }

    public String getDocumentStr() {
        return documentStr;
    }

    public static void update(int StopID) {

    }

//    public static void choose(int stopID) {
//        StopWatch sw = stopWatchMap.get(stopID);
//        sw.instantStop = Instant.now();
//        long timeDifference = sw.instantStop.getEpochSecond() - sw.instantStart.getEpochSecond();
//        if (timeDifference > timeUpdate) {
//            Cache.update(stopID);
//            sw.instantStart = Instant.now();
//        }
//    }
}

