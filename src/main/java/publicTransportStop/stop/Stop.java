package publicTransportStop.stop;

import java.util.Objects;

public class Stop {
    private int stopID;

    private String title;

    private String adjacentStreet;

    private String direction;

    private String buses;

    private String trolleybuses;

    private String trams;

    private String metros;

    private String electricTrains;

    private String riverTransports;

    public Stop(int stopID, String title, String adjacentStreet, String direction, String buses,
                String trolleybuses, String trams, String metros, String electricTrains, String riverTransports) {
        this.stopID = stopID;
        this.title = title;
        this.adjacentStreet = adjacentStreet;
        this.direction = direction;
        this.buses = buses;
        this.trolleybuses = trolleybuses;
        this.trams = trams;
        this.metros = metros;
        this.electricTrains = electricTrains;
        this.riverTransports = riverTransports;
    }

    public String createFullStopTitle(int index) {
        return String.format("%s. %s %s %s", index, this.getTitle(), this.getAdjacentStreet(), this.getDirection());
    }

    public boolean isThereACompleteLackOfPublicTransport() {
        return this.buses.isEmpty() && this.trolleybuses.isEmpty()
                && this.trams.isEmpty() && this.electricTrains.isEmpty()
                && this.riverTransports.isEmpty() && this.metros.isEmpty();
    }

    public int getStopID() {
        return stopID;
    }

    public String getTitle() {
        return title;
    }

    public String getAdjacentStreet() {
        return adjacentStreet;
    }

    public String getDirection() {
        return direction;
    }

    public String getBuses() {
        return buses;
    }

    public String getTrolleybuses() {
        return trolleybuses;
    }

    public String getTrams() {
        return trams;
    }

    public String getMetros() {
        return metros;
    }

    public String getElectricTrains() {
        return electricTrains;
    }

    public String getRiverTransports() {
        return riverTransports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stop stop = (Stop) o;
        return stopID == stop.stopID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stopID);
    }
}
