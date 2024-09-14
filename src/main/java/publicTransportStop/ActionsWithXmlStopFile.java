package publicTransportStop;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class ActionsWithXmlStopFile {
    private static List<Double> timeUpdateStopslist = new ArrayList<>();
    private static Path xmlStops = Path.of("C:\\Users\\Егор\\IdeaProjects\\myProject\\src\\main\\java\\publicTransportStop\\Stops");

    public static void updateOrNot() {
        if (timeUpdateStopslist.size() == 1) {
            return;
        } else if ((timeUpdateStopslist.get(1) > timeUpdateStopslist.get(0)) || !Files.exists(xmlStops)) {
            update();
        }
        timeUpdateStopslist.removeFirst();
    }

    public static void add(String time) {
        timeUpdateStopslist.add(Double.valueOf((time)));
    }

    public static void update() {
        try {
            URL url = new URL("https://tosamara.ru/api/v2/classifiers/stopsFullDB.xml");
            InputStream in = url.openStream();
            Files.copy(in, xmlStops, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Неполадки с соединением");
        }
    }

    public static void save() {
        SaveLoad.writeToFile(timeUpdateStopslist);
    }

    public static void load() {
        if (SaveLoad.getFile().length() == 0) {
            return;
        }
        timeUpdateStopslist = SaveLoad.readFromFile();
    }


}
