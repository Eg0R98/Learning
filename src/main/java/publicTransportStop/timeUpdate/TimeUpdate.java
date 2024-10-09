package publicTransportStop.timeUpdate;

import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.SQLException;

public interface TimeUpdate {
    boolean updateOrNot() throws IOException, JAXBException, SQLException, ClassNotFoundException;
}
