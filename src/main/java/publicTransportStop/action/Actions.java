package publicTransportStop.action;

import jakarta.xml.bind.JAXBException;
import publicTransportStop.exceptions.ConnectException;

public interface Actions {
    void update() throws ClassNotFoundException, ConnectException;

    void loadStops() throws ClassNotFoundException, JAXBException, ConnectException;
}
