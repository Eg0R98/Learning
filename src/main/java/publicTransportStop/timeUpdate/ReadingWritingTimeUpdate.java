package publicTransportStop.timeUpdate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class ReadingWritingTimeUpdate {
    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private static File file = new File("C:\\Users\\Егор\\IdeaProjects\\myProject\\src\\main\\java\\publicTransportStop\\timeUpdate\\TimeUpdateXmlStopFile");

    public static void writeToFile(Double time) throws IOException {
        mapper.writeValue(file, time);
    }

    public static Double readFromFile() throws IOException {
        Double time = null;
        if (file.exists()) {
            time = mapper.readValue(file, Double.class);
        }
        return time;
    }
}
