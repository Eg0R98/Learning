package publicTransportStop.jdbc.timeUpdateToSql;

import jakarta.xml.bind.JAXBException;

import java.net.MalformedURLException;
import java.sql.SQLException;

public interface TimeUpdateToSql {
    void insertTimeUpdateToTable(Double var1) throws SQLException, ClassNotFoundException;

    Double selectTimeUpdateFromTable() throws SQLException, ClassNotFoundException, MalformedURLException, JAXBException;

    void updateTimeUpdateTable(Double var1) throws SQLException, ClassNotFoundException;
}
