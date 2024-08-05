package PublicTransportStop;

import PublicTransportStop.Cache;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.ConnectException;

public class Request {


    public static Document httpRequest(int stopID) throws ConnectException {
        Document document = null;
        try {
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
                if (document == null) throw new ConnectException("Не удалось выполнить запрос");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return document;
    }
}
