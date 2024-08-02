package PublicTransportStop;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parsing {
    public static void parseTableFromTransportStop(Document document) {
        Element headers = document.select("thead").getFirst();
        Elements td = headers.select("td");
        System.out.printf("%-14s", td.get(0).text());
        System.out.printf("%-59s", td.get(1).text());
        System.out.printf("%s", td.get(2).text());
        System.out.println();

        Elements tr = document.select("tbody").select("tr");

        for (int i = 0; i < tr.size(); i++) {
            Elements el = tr.get(i).select("td.trans-num, a, div.trans-model, td.trans-position");
            for (int j = 0; j < el.size() / 2; j++) {
                System.out.printf("%-14s", el.get(j).ownText());
            }
            System.out.println();

            for (int j = el.size() / 2; j < el.size(); j++) {
                System.out.printf("%-14s", "");
                System.out.printf("%-45s", el.get(j).ownText());
            }
            System.out.println();
        }
    }
}
