package PublicTransportStop;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.InputMismatchException;

public class Stop {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://tosamara.ru/xml_bridge.php");

            InputStream is = url.openStream();
            byte[] buffer = is.readAllBytes();
            String str = new String(buffer);

            System.out.println(str);

            is.close();

        } catch (InputMismatchException e) {
            System.out.println("Ошибка. Некорректный ввод.");
        } catch (MalformedURLException | ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

