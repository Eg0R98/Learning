package PublicTransportStop;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.rmi.ConnectException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                int stopNumber = Input.inputStopID(scanner);
                String headersAndTableFromCache = Cache.searchAndGet(stopNumber);
                if (headersAndTableFromCache != null) {
                    Input.PrintFromCache(headersAndTableFromCache);
                    boolean choose = Cache.updateOrNote(stopNumber);
                    if (choose) {
                        Document document = Request.httpRequest(stopNumber);
                        Elements header = Parsing.parseHeadersFromTransportStop(document);
                        Elements table = Parsing.parseTableFromTransportStop(document);
                        Cache.update(stopNumber, header, table);
                    }
                } else {
                    Document document = Request.httpRequest(stopNumber);
                    Elements header = Parsing.parseHeadersFromTransportStop(document);
                    Elements table = Parsing.parseTableFromTransportStop(document);
                    Input.headersPrintFromServer(header);
                    Input.tablePrintFromServer(table);
                    Cache.add(stopNumber, header, table);
                }
                boolean stop = Input.isStopProgram(scanner);
                if (stop) break;
            }
        } catch (InputMismatchException e) {
            System.err.println("Некорректный ввод");
        } catch (ConnectException e) {
            e.getMessage();
        }

    }


}

