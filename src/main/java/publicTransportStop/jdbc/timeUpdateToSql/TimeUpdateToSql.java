package publicTransportStop.jdbc.timeUpdateToSql;

import jakarta.xml.bind.JAXBException;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.SQLException;

public interface TimeUpdateToSql {
    void insertTimeUpdateToTable(Double timeUpdate, Connection connection) throws SQLException, ClassNotFoundException;

    Double selectTimeUpdateFromTable(Connection connection) throws SQLException, ClassNotFoundException, MalformedURLException, JAXBException;

    void updateTimeUpdateTable(Double timeUpdate, Connection connection) throws SQLException, ClassNotFoundException;
}
