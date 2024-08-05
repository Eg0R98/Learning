package PublicTransportStop;

import org.jsoup.select.Elements;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static Map<Integer, Cache> cacheMap = new HashMap<>();
    private static long timeUpdate = 60;
    private Instant instantStart;
    private String documentStr;

    private Cache(String documentStr) {
        this.instantStart = Instant.now();
        this.documentStr = documentStr;
    }

    public static void add(int stopNumber, Elements headers, Elements table) {
        StringBuilder builder = new StringBuilder("");
        String s1 = String.format("%-14s", headers.get(0).text());
        String s2 = String.format("%-59s", headers.get(1).text());
        String s3 = String.format("%s\n", headers.get(2).text());
        builder.append(s1).append(s2).append(s3);

        for (int i = 0; i < table.size(); i++) {
            Elements el = table.get(i).select("td.trans-num, a, div.trans-model, td.trans-position");
            for (int j = 0; j < el.size() / 2; j++) {
                String s = String.format("%-14s", el.get(j).ownText());
                builder.append(s);
            }
            builder.append("\n");
            for (int j = el.size() / 2; j < el.size(); j++) {
                String s4 = String.format("%-14s", "");
                String s5 = String.format("%-45s", el.get(j).ownText());
                builder.append(s4).append(s5);
            }
            builder.append("\n");
        }
        cacheMap.put(stopNumber, new Cache(builder.toString()));
    }

    public static String searchAndGet(int stopNumber) {
        if (cacheMap.containsKey(stopNumber)) {
            Cache cache = cacheMap.get(stopNumber);
            return cache.documentStr;
        }
        return null;
    }

    public static void update(int stopNumber, Elements headers, Elements table) {
        Cache cache = cacheMap.get(stopNumber);
        StringBuilder builder = new StringBuilder("");
        String s1 = String.format("%-14s", headers.get(0).text());
        String s2 = String.format("%-59s", headers.get(1).text());
        String s3 = String.format("%s\n", headers.get(2).text());
        builder.append(s1).append(s2).append(s3);

        for (int i = 0; i < table.size(); i++) {
            Elements el = table.get(i).select("td.trans-num, a, div.trans-model, td.trans-position");
            for (int j = 0; j < el.size() / 2; j++) {
                String s = String.format("%-14s", el.get(j).ownText());
                builder.append(s);
            }
            builder.append("\n");
            for (int j = el.size() / 2; j < el.size(); j++) {
                String s4 = String.format("%-14s", "");
                String s5 = String.format("%-45s", el.get(j).ownText());
                builder.append(s4).append(s5);
            }
            builder.append("\n");
        }
        cache.documentStr = builder.toString();
        cache.setInstantStart(Instant.now());
    }

    public static boolean updateOrNote(int stopID) {
        Cache cache = cacheMap.get(stopID);
        long timeDifference = Instant.now().getEpochSecond() - cache.instantStart.getEpochSecond();
        if (timeDifference > timeUpdate) {
            return true;
        }
        return false;
    }

    public void setInstantStart(Instant instantStart) {
        this.instantStart = instantStart;
    }
}

