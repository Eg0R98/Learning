package publicTransportStop;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ActionsWithXmlStopFile.load();
            String time = Request.xmlTimeUpdateStopRequest();
            ActionsWithXmlStopFile.add(time);
            ActionsWithXmlStopFile.updateOrNot();
            Stops stops = Unmarshalling.umarshallXmlStops();

            while (true) {
                String stopTitle = Input.inputTitle(scanner);
                List<Stop> matches = stops.getMatches(stopTitle);
                Input.printMatches(matches);
                int numberOfMatches = Input.chooseNumberOfMatches(scanner);
                int stopNumber = Stops.getStopID(matches.get(numberOfMatches - 1));
                String responseFromCache = Cache.searchAndGet(stopNumber);
                if (responseFromCache != null) {
                    Input.printResponse(responseFromCache);
                } else {
                    String responseFromServer = Request.httpRequest(stopNumber);
                    Input.printResponse(responseFromServer);
                    Cache.add(stopNumber, responseFromServer);
                }
                boolean stop = Input.isStopProgram(scanner);
                if (stop) break;
            }
            ActionsWithXmlStopFile.save();
        } catch (NotMatchException e) {
            System.err.println("Ошибка. Совпадений не найдено");
        } catch (ConnectException e) {
            System.err.println("C соединением проблемы");
        }
    }
}

