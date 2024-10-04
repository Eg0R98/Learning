package publicTransportStop.action;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.sql.SQLException;

public interface Actions {
    void update() throws IOException, JAXBException, SQLException, ClassNotFoundException;

    void loadStops() throws SQLException, JAXBException, IOException, ClassNotFoundException;
}
