package PublicTransportStop;

import org.jsoup.nodes.Document;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                int stopNumber = Input.inputStopID(scanner);
//                    Document document = Request.httpRequest(stopNumber);
//                    Input.headersPrintFromServer(Parsing.parseHeadersFromTransportStop(document));
//                    Input.tablePrintFromServer(Parsing.parseTableFromTransportStop(document));

                boolean stop = Input.isStopProgram(scanner);
                if (stop) break;

            } catch (InputMismatchException e) {
                System.err.println("Некорректный ввод");
            }
        }

        }
    }

