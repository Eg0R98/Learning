package publicTransportStop.timeUpdate;

import jakarta.xml.bind.JAXBException;
import publicTransportStop.transformation.Unmarshalling;

import java.io.IOException;
import java.net.URL;

public class TimeUpdate {
    private static Double oldTimeUpdate;
    private static URL urlTimeUpdate;

    private static void initialize() throws IOException {
        urlTimeUpdate = new URL("https://tosamara.ru/api/v2/classifiers");
        oldTimeUpdate = ReadingWritingTimeUpdate.readFromFile();
    }

    public static boolean updateOrNot() throws IOException, JAXBException {
        initialize();
        Unmarshalling.unmarshallTimeUpdate(urlTimeUpdate);
        if (oldTimeUpdate == null) {
            Double timeUpdate = Classifiers.getNewTimeUpdate();
            ReadingWritingTimeUpdate.writeToFile(timeUpdate);
            return true;
        }
        Double newTimeUpdate = Classifiers.getNewTimeUpdate();
        if (newTimeUpdate > oldTimeUpdate) {
            oldTimeUpdate = newTimeUpdate;
            ReadingWritingTimeUpdate.writeToFile(oldTimeUpdate);
            return true;
        }
        return false;
    }


}
