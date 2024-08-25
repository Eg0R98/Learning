package publicTransportStop;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StopRepository.setMap(Request.xmlStopDocumentRequest());
            while (true) {
                String stopTitle = Input.inputTitle(scanner);
                List<String> matches = StopRepository.getMatches(stopTitle);
                Input.printMatches(matches);
                String numberOfMatches = Input.chooseNumberOfMatches(scanner);
                String titleWithDirection = StopRepository.getTitleWithDirection(numberOfMatches, matches);
                int stopNumber = StopRepository.getStopID(titleWithDirection);
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
        } catch (InputMismatchException e) {
            System.err.println("Некорректный ввод");
        } catch (ConnectException | NotMatchException e) {
            e.printStackTrace();
        }
    }
}

