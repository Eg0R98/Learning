package PublicTransportStop;

import PublicTransportStop.Cache;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {
    public static Document httpRequest(int stopID) {
        Document document = null;
        try {
            Document cache = Cache.searchAndGet(stopID);
            if (cache != null) {
                StopWatch.choose(stopID);
                return cache;
            }
            URL url = new URL("https://tosamara.ru/xml_bridge.php/");
            String params = String.format("method=getFirstArrivalToStop&KS_ID=%d&COUNT=10&version=main&eng=0", stopID);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setDoOutput(true);
            try (DataOutputStream dos = new DataOutputStream(con.getOutputStream())) {
                dos.writeBytes(params);
            }
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                document = Jsoup.parse(con.getInputStream(), "UTF-8", "https://tosamara.ru/xml_bridge.php/");
                Cache.add(stopID, document);
                StopWatch.add(stopID);
            } else System.err.println("С соединением проблемы");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return document;
    }
}
