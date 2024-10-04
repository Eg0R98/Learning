package publicTransportStop.transformation;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import publicTransportStop.stop.StopsXmlUnmarshallRepository;
import publicTransportStop.timeUpdate.Classifiers;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

public class Unmarshalling {

    public static StopsXmlUnmarshallRepository unmarshallXmlStops(URL urlStops) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(StopsXmlUnmarshallRepository.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StopsXmlUnmarshallRepository stopsXmlUnmarshallRepository = (StopsXmlUnmarshallRepository) unmarshaller.unmarshal(urlStops);

        return stopsXmlUnmarshallRepository;
    }

    public static StopsXmlUnmarshallRepository unmarshallXmlStops(Path xmlStops) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(StopsXmlUnmarshallRepository.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StopsXmlUnmarshallRepository stopsXmlUnmarshallRepository = (StopsXmlUnmarshallRepository) unmarshaller.unmarshal(xmlStops.toFile());

        return stopsXmlUnmarshallRepository;
    }

    public static Classifiers unmarshallTimeUpdate(URL urlTimeUpdate) throws JAXBException, MalformedURLException {
        JAXBContext context = JAXBContext.newInstance(Classifiers.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Classifiers classifiers = (Classifiers) unmarshaller.unmarshal(urlTimeUpdate);

        return classifiers;
    }

}
