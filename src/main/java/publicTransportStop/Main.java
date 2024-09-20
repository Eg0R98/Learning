package publicTransportStop;

import jakarta.xml.bind.JAXBException;
import publicTransportStop.cache.Cache;
import publicTransportStop.exceptions.ConnectException;
import publicTransportStop.exceptions.NotMatchException;
import publicTransportStop.stop.Stop;
import publicTransportStop.stop.Stops;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ActionsWithXmlStopFile.loadStops();
            while (true) {
                String stopTitle = Input.inputTitle(scanner);
                List<Stop> matches = Stops.getMatches(stopTitle);
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
        } catch (NotMatchException | ConnectException | JAXBException | IOException e) {
            Input.printExceptionMessage(e);
        }
    }
}

