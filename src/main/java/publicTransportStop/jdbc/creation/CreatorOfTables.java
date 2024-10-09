package publicTransportStop.jdbc.creation;

import java.sql.Connection;
import java.sql.SQLException;

public interface CreatorOfTables {
    void createTableForTimeUpdate(Connection con) throws SQLException;

    void createTableForListStops(Connection connection) throws SQLException;

    boolean isExist(String tableName, Connection connection) throws SQLException;
}
