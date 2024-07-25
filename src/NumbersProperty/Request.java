package NumbersProperty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Request {
    public static StringBuilder httpRequest(int number, String fact) {
        StringBuilder response = new StringBuilder("");
        if (fact.equals("trivia") || fact.equals("year") || fact.equals("math") || fact.equals("date")) {
            String s = String.format("http://numbersapi.com/%d/%s", number, fact);
            try {
                URL url = new URL(s);
                try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

                    String inputLine;

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                        response.append("\n");
                    }

                    String numFact = String.format("%d/%s", number, fact);
                    Cache.add(numFact, response);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else System.err.println("Некорректный ввод");
        return response;
    }
}
