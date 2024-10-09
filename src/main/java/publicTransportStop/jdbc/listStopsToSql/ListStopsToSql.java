package publicTransportStop.jdbc.listStopsToSql;

import publicTransportStop.stop.StopXmlUnmarshall;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ListStopsToSql {
    void insertListStopsToTable(List<StopXmlUnmarshall> listStops, Connection connection) throws SQLException, ClassNotFoundException;

    List<StopXmlUnmarshall> selectListStopsFromTable(Connection connection) throws SQLException, ClassNotFoundException;

    void updateStopsTable(List<StopXmlUnmarshall> listStops, Connection connection) throws SQLException, ClassNotFoundException;
}
