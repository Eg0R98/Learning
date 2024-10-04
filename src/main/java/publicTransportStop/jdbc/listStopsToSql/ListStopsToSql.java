package publicTransportStop.jdbc.listStopsToSql;

import publicTransportStop.stop.StopXmlUnmarshall;

import java.sql.SQLException;
import java.util.List;

public interface ListStopsToSql {
    void insertListStopsToTable(List<StopXmlUnmarshall> listStops) throws SQLException, ClassNotFoundException;

    List<StopXmlUnmarshall> selectListStopsFromTable() throws SQLException, ClassNotFoundException;

    void updateStopsTable(List<StopXmlUnmarshall> listStops) throws SQLException, ClassNotFoundException;
}
