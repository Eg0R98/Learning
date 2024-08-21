package numbersProperty;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            Cache.load();
            while (true) {
                int number = Input.inputNumber(scanner);
                String fact = Input.inputFact(scanner);
                String numFact = String.format("%d/%s", number, fact);
                String responseFromCache = Cache.searchAndGet(numFact);
                if (responseFromCache != null) {
                    Input.printResponse(responseFromCache);
                } else {
                    String response = Request.httpRequest(numFact);
                    Input.printResponse(response);
                    Cache.add(numFact, response);
                }
                boolean stop = Input.isStopProgram(scanner);
                if (stop) break;
            }

        } catch (InputMismatchException e) {
            System.err.println("Некорректный ввод");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            Cache.save();
        }
    }


}

