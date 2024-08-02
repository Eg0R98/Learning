package PublicTransportStop;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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

    public static void update(int StopID) {
        try {
            URL url = new URL("https://tosamara.ru/xml_bridge.php/");
            String params = String.format("method=getFirstArrivalToStop&KS_ID=%d&COUNT=10&version=main&eng=0", StopID);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setDoOutput(true);
            try (DataOutputStream dos = new DataOutputStream(con.getOutputStream())) {
                dos.writeBytes(params);
            }
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Document document = Jsoup.parse(con.getInputStream(), "UTF-8", "https://tosamara.ru/xml_bridge.php/");
                Cache.add(StopID, document);
            } else System.err.println("С соединением проблемы");
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}

