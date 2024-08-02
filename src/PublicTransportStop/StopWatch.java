package PublicTransportStop;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class StopWatch {
    private static long timeUpdate = 30;
    private static Map<Integer, StopWatch> stopWatchMap = new HashMap<>();
    private Instant instantStart;
    private Instant instantStop;

    public static void add(int stopID) {
        StopWatch up = new StopWatch();
        stopWatchMap.put(stopID, up);
        up.instantStart = Instant.now();
    }

    public static void choose(int stopID) {
        StopWatch sw = stopWatchMap.get(stopID);
        sw.instantStop = Instant.now();
        long timeDifference = sw.instantStop.getEpochSecond() - sw.instantStart.getEpochSecond();
        if (timeDifference > timeUpdate) {
            Cache.update(stopID);
            sw.instantStart = Instant.now();
        }
    }


}
