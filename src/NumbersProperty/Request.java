package NumbersProperty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Request {
    public static String httpRequest(int number, String fact) {
        StringBuilder response = new StringBuilder("");
        if (fact.equals("trivia") || fact.equals("year") || fact.equals("math") || fact.equals("date")) {
            String numFact = String.format("%d/%s", number, fact);
            String cache = Cache.searchAndGet(numFact);
            if (cache != null) return cache;
            try {
                URL url = new URL(String.format("http://numbersapi.com/%s", numFact));
                try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

                    String inputLine;

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                        response.append("\n");
                    }
                    Cache.add(numFact, response.toString());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else System.err.println("Некорректный ввод");

        return response.toString();
    }

}
