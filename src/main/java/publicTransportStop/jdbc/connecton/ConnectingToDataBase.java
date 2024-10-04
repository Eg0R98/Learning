package publicTransportStop.jdbc.connecton;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectingToDataBase {
    Connection connectToDataBase() throws SQLException, ClassNotFoundException;

}
