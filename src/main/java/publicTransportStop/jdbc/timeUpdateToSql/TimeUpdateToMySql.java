package publicTransportStop.jdbc.timeUpdateToSql;

import java.sql.*;

public class TimeUpdateToMySql implements TimeUpdateToSql {

    @Override
    public void insertTimeUpdateToTable(Double timeUpdate, Connection con) throws SQLException {
        String query = "Insert into timeupdate(time) value(?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDouble(1, timeUpdate);
            ps.addBatch();
            ps.executeBatch();
        }
    }

    @Override
    public void updateTimeUpdateTable(Double timeUpdate, Connection con) throws SQLException {
        String query = "update timeupdate set time = ? where id=1";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDouble(1, timeUpdate);
            ps.addBatch();
            ps.executeBatch();
        }
    }

    @Override
    public Double selectTimeUpdateFromTable(Connection con) throws SQLException {
        Double timeUpdate = null;
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select time from timeupdate where id = 1");
            if (rs.next()) {
                timeUpdate = rs.getDouble(1);
            }
        }
        return timeUpdate;
    }
}
