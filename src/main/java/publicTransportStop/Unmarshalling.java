package publicTransportStop;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class Unmarshalling {

    public static Stops umarshallXmlStops() {
        File xmlStops = new File("C:\\Users\\Егор\\IdeaProjects\\myProject\\src\\main\\java\\publicTransportStop\\Stops");
        Stops stops;
        try {
            JAXBContext context = JAXBContext.newInstance(Stops.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            stops = (Stops) unmarshaller.unmarshal(xmlStops);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return stops;
    }

}
