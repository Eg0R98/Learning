package numbersProperty;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.Map;


public class SaveLoad {
    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private static File file = new File("C:\\Users\\Егор\\IdeaProjects\\myProject\\src\\main\\java\\numbersProperty\\Учебный файл1.txt");
    private static MapType mapType = mapper.getTypeFactory().constructMapType(Map.class, String.class, CacheItem.class);

    public static void writeToFile(Map<String, CacheItem> mapCache) throws IOException {
        mapper.writeValue(file, mapCache);
    }

    public static Map<String, CacheItem> readFromFile() throws IOException {
        return mapper.readValue(file, mapType);
    }

}
