package PublicTransportStop;

import CRUD.Solution;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stop {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://tosamara.ru/xml_bridge.php/");
            String params = "method=getFirstArrivalToStop&KS_ID=1160&COUNT=10&version=main&eng=0";
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setDoOutput(true);

            try (DataOutputStream dos = new DataOutputStream(con.getOutputStream())) {
                dos.writeBytes(params);
            }
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Document document = Jsoup.parse(con.getInputStream(), "UTF-8", "https://tosamara.ru/xml_bridge.php/");
                Stop.parse(document);

            } else System.err.println("С соединением проблемы");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void parse(Document document) {
        Element headers = document.select("thead").getFirst();
        Elements td = headers.select("td");
        System.out.print(String.format("%s    ", td.get(0).text()));
        System.out.print(String.format("%s                              ", td.get(1).text()));
        System.out.print(String.format("%s", td.get(2).text()));
        System.out.println();

        Elements tr = document.select("tbody").select("tr");

        for (int i = 0; i < tr.size(); i++) {
            Elements el = tr.get(i).select("td.trans-num, a, div.trans-model, td.trans-position");
            for (int j = 0; j < el.size() / 2; j++) {
                System.out.print(String.format("%-14s", el.get(j).ownText()));
            }
            System.out.println();

            for (int j = el.size() / 2; j < el.size(); j++) {
                System.out.print(String.format("              %-45s", el.get(j).ownText()));
            }
            System.out.println();
        }
    }

}
