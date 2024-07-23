package PublicTransportStop;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Stop {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://tosamara.ru/xml_bridge.php/");
            String params = "method=getFirstArrivalToStop&KS_ID=1160&COUNT=10&version=main&eng=0";
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setDoOutput(true);

            try(DataOutputStream dos = new DataOutputStream(con.getOutputStream())) {
                dos.writeBytes(params);
            }

            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                StringBuilder builder = new StringBuilder("");
                try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = br.readLine()) != null) {
                        builder.append(inputLine);
                        builder.append("\n");
                    }
                }
                System.out.println(builder);
            }
            else System.err.println("С соединением проблемы");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
