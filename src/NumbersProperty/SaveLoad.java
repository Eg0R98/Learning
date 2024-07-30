package NumbersProperty;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;


public class SaveLoad {
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file = new File("C:\\Users\\Егор\\Desktop\\Учебный файл1.txt");

    public static void writeToFile(Map<String, String> mapCache) throws IOException {
        mapper.writeValue(file, mapCache);
    }

    public static void readFromFile() throws IOException {
        Map<String, String> map;
        map = mapper.readValue(file, Map.class);
        Cache.setCacheMap(map);

    }
}
