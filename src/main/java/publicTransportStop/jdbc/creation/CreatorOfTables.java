package publicTransportStop.jdbc.creation;

import java.sql.Connection;
import java.sql.SQLException;

public interface CreatorOfTables {
    void createTableForTimeUpdate(Connection con) throws SQLException;

    void createTableForListStops(Connection con) throws SQLException;

    boolean isExist(String tableName, Connection con) throws SQLException;
}
