package publicTransportStop;

import jakarta.xml.bind.JAXBException;
import publicTransportStop.stop.ConvertingStopXmlUnmarshallToStop;
import publicTransportStop.stop.Stop;
import publicTransportStop.stop.Stops;
import publicTransportStop.stop.StopsXmlUnmarshallRepository;
import publicTransportStop.timeUpdate.TimeUpdate;
import publicTransportStop.transformation.Unmarshalling;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class ActionsWithXmlStopFile {
    private static Path xmlStops = Path.of("C:\\Users\\Егор\\IdeaProjects\\myProject\\src\\main\\java\\publicTransportStop\\stop\\Stops");

    public static void update(InputStream in, Path xmlStops) throws IOException {
        Files.copy(in, xmlStops, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void loadStops() throws JAXBException, IOException {
        if (TimeUpdate.updateOrNot() || Files.notExists(xmlStops))
            update(Request.requestForUpdateXmlStopsFile(), xmlStops);
        StopsXmlUnmarshallRepository sxur = Unmarshalling.unmarshallXmlStops(xmlStops);
        List<Stop> stops = ConvertingStopXmlUnmarshallToStop.convert(sxur.getListStopXmlUnmarshall());
        Stops.setListStops(stops);

    }


}
