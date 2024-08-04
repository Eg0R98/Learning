package PublicTransportStop;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parsing {
    public static Elements parseHeadersFromTransportStop(Document document) {
        Elements td = document.select("thead").getFirst().select("td");
        return td;
    }

    public static Elements parseTableFromTransportStop(Document document) {
        Elements tr = document.select("tbody").select("tr");
        return tr;
    }
}
