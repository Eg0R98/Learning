package publicTransportStop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                int stopNumber = Input.inputStopID(scanner);
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
        } catch (ConnectException e) {
            e.printStackTrace();
        }
    }
}

