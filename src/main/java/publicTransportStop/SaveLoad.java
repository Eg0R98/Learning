package publicTransportStop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class SaveLoad {
    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private static File file = new File("C:\\Users\\Егор\\IdeaProjects\\myProject\\src\\main\\java\\publicTransportStop\\TimeUpdateXmlStopFile");
    private static CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Double.class);

    public static void writeToFile(List<Double> timeUpdateStopslist) {
        try {
            if (file.length() > 0) {
                FileOutputStream fos = new FileOutputStream(file);
                fos.close();
            }
            mapper.writeValue(file, timeUpdateStopslist);
        } catch (IOException e) {
            System.out.println("С соединением проблемы");
        }
    }

    public static List<Double> readFromFile() {
        List<Double> timeUpdate = null;
        try {
            if (file.length() > 0) {
                timeUpdate = mapper.readValue(file, collectionType);
            }
        } catch (IOException e) {
            System.out.println("С соединением проблемы");
        }
        return timeUpdate;
    }

    public static File getFile() {
        return file;
    }
}
