package numbersProperty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Request {
    public static String httpRequest(String numFact) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(String.format("http://numbersapi.com/%s", numFact));
            try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                    response.append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response.toString();
    }

}
