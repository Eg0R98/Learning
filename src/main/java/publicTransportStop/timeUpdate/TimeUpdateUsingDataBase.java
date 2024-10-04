package publicTransportStop.timeUpdate;

import jakarta.xml.bind.JAXBException;
import publicTransportStop.jdbc.connecton.ConnectingToMySQLDataBase;
import publicTransportStop.jdbc.creation.CreatorOfMySqlTables;
import publicTransportStop.jdbc.creation.CreatorOfTables;
import publicTransportStop.jdbc.timeUpdateToSql.TimeUpdateToMySql;
import publicTransportStop.jdbc.timeUpdateToSql.TimeUpdateToSql;
import publicTransportStop.transformation.Unmarshalling;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

public class TimeUpdateUsingDataBase implements TimeUpdate {
    private Double oldTimeUpdate;
    private URL urlTimeUpdate = new URL("https://tosamara.ru/api/v2/classifiers");
    private TimeUpdateToSql con = new TimeUpdateToMySql();
    private Connection conn = (new ConnectingToMySQLDataBase()).connectToDataBase();

    public TimeUpdateUsingDataBase() throws SQLException, MalformedURLException, ClassNotFoundException {
    }

    @Override
    public boolean updateOrNot() throws IOException, JAXBException, SQLException, ClassNotFoundException {
        Unmarshalling.unmarshallTimeUpdate(urlTimeUpdate);
        CreatorOfTables creator = new CreatorOfMySqlTables();
        Double newTimeUpdate;
        if (!creator.isExist("timeupdate", conn)) {
            creator.createTableForTimeUpdate(conn);
            newTimeUpdate = Classifiers.getNewTimeUpdate();
            TimeUpdateToSql timeUpdateToSql = new TimeUpdateToMySql();
            timeUpdateToSql.insertTimeUpdateToTable(newTimeUpdate);
            return false;
        } else {
            oldTimeUpdate = con.selectTimeUpdateFromTable();
            newTimeUpdate = Classifiers.getNewTimeUpdate();
            if (oldTimeUpdate == null || newTimeUpdate > oldTimeUpdate) {
                oldTimeUpdate = newTimeUpdate;
                con.insertTimeUpdateToTable(oldTimeUpdate);
                return true;
            }
            return false;

        }
    }

}
