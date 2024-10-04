package publicTransportStop.jdbc.timeUpdateToSql;

import publicTransportStop.jdbc.connecton.ConnectingToMySQLDataBase;

import java.sql.*;

public class TimeUpdateToMySql implements TimeUpdateToSql {
    private Connection conn = (new ConnectingToMySQLDataBase()).connectToDataBase();

    public TimeUpdateToMySql() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void insertTimeUpdateToTable(Double timeUpdate) throws SQLException {
        String query = "Insert into timeupdate(time) value(?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDouble(1, timeUpdate);
            ps.addBatch();
            ps.executeBatch();
        }
    }

    @Override
    public void updateTimeUpdateTable(Double timeUpdate) throws SQLException {
        String query = "update timeupdate set time = ? where id=1";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDouble(1, timeUpdate);
            ps.addBatch();
            ps.executeBatch();
        }
    }

    @Override
    public Double selectTimeUpdateFromTable() throws SQLException {
        Double timeUpdate = null;
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select time from timeupdate where id = 1");
            if (rs.next()) {
                timeUpdate = rs.getDouble(1);
            }
        }
        return timeUpdate;
    }
}
