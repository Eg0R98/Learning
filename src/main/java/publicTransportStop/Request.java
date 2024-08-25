package publicTransportStop;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Request {
    public static String httpRequest(int stopID) throws ConnectException {
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
                if (document == null) throw new ConnectException("C соединением проблемы");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Parsing.parseHttpResponse(document);
    }

    public static Map<String, Integer> xmlStopDocumentRequest() throws ConnectException {
        Document document = null;
        try {
            URL url = new URL("https://tosamara.ru/api/v2/classifiers/stops.xml");
            document = Jsoup.parse(url.openStream(), "UTF-8", "https://tosamara.ru/api/v2/classifiers/stops.xml");
            if (document == null) throw new ConnectException("C соединением проблемы");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Parsing.parseXmlStopResponse(document);
    }
}
