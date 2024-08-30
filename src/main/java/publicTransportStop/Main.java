package publicTransportStop;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StopRepository.setListStop(Request.xmlStopDocumentRequest());
            while (true) {
                String stopTitle = Input.inputTitle(scanner);
                Map<Integer, Stop> matches = StopRepository.getMatches(stopTitle);
                Input.printMatches(matches);
                int numberOfMatches = Input.chooseNumberOfMatches(scanner);
                int stopNumber = StopRepository.getStopID(matches.get(numberOfMatches));
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
        } catch (NotMatchException e) {
            System.err.println("Ошибка. Совпадений не найдено");
        } catch (ConnectException e) {
            System.err.println("C соединением проблемы");
        }
    }
}

