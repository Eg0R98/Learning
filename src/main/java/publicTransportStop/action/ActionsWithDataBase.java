package publicTransportStop.action;

import jakarta.xml.bind.JAXBException;
import publicTransportStop.jdbc.connecton.ConnectingToMySQLDataBase;
import publicTransportStop.jdbc.creation.CreatorOfMySqlTables;
import publicTransportStop.jdbc.creation.CreatorOfTables;
import publicTransportStop.jdbc.listStopsToSql.ListStopsToMySql;
import publicTransportStop.jdbc.listStopsToSql.ListStopsToSql;
import publicTransportStop.stop.ConvertingStopXmlUnmarshallToStop;
import publicTransportStop.stop.Stop;
import publicTransportStop.stop.StopXmlUnmarshall;
import publicTransportStop.stop.Stops;
import publicTransportStop.timeUpdate.TimeUpdateUsingDataBase;
import publicTransportStop.transformation.Unmarshalling;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ActionsWithDataBase implements Actions {
    private TimeUpdateUsingDataBase timeUpdateUsingDataBase = new TimeUpdateUsingDataBase();
    private URL urlStops = new URL("https://tosamara.ru/api/v2/classifiers/stopsFullDB.xml");
    private ListStopsToSql con = new ListStopsToMySql();
    private Connection conn = (new ConnectingToMySQLDataBase()).connectToDataBase();
    private ListStopsToSql listStopsToSql = new ListStopsToMySql();

    public ActionsWithDataBase() throws MalformedURLException, SQLException, ClassNotFoundException {
    }

    public void update() throws JAXBException, SQLException, ClassNotFoundException {
        List<StopXmlUnmarshall> listStops = Unmarshalling.unmarshallXmlStops(urlStops).getListStopXmlUnmarshall();
        listStopsToSql.updateStopsTable(listStops);
    }

    public void loadStops() throws JAXBException, IOException, SQLException, ClassNotFoundException {
        CreatorOfTables creator = new CreatorOfMySqlTables();
        List<StopXmlUnmarshall> listStops;
        if (!creator.isExist("stops", conn)) {
            creator.createTableForListStops(conn);
            listStops = Unmarshalling.unmarshallXmlStops(urlStops).getListStopXmlUnmarshall();
            listStopsToSql.insertListStopsToTable(listStops);
        } else if (timeUpdateUsingDataBase.updateOrNot()) update();

        listStops = con.selectListStopsFromTable();
        List<Stop> stops = ConvertingStopXmlUnmarshallToStop.convert(listStops);
        Stops.setListStops(stops);
    }
}
