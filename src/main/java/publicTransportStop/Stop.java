package publicTransportStop;

import java.util.Objects;

public class Stop {
    private int stopID;
    private String title;
    private String adjacentStreet;
    private String direction;
    private String busNumbers;
    private String trolleybusesNumbers;
    private String tramsNumbers;
    private String metrosNumbers;
    private String electricTrainsNumbers;
    private String riverTransportsNumbers;

    public Stop(int stopID, String title, String adjacentStreet, String direction, String busNumbers, String tramsNumbers,
                String trolleybusesNumbers, String metrosNumbers,
                String electricTrainsNumbers, String riverTransportsNumbers) {
        this.stopID = stopID;
        this.title = title;
        this.adjacentStreet = adjacentStreet;
        this.direction = direction;
        this.busNumbers = busNumbers;
        this.tramsNumbers = tramsNumbers;
        this.trolleybusesNumbers = trolleybusesNumbers;
        this.metrosNumbers = metrosNumbers;
        this.electricTrainsNumbers = electricTrainsNumbers;
        this.riverTransportsNumbers = riverTransportsNumbers;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "stopID=" + stopID +
                ", title='" + title + '\'' +
                ", adjacentStreet='" + adjacentStreet + '\'' +
                ", direction='" + direction + '\'' +
                ", busNumbers='" + busNumbers + '\'' +
                ", trolleybusesNumbers='" + trolleybusesNumbers + '\'' +
                ", tramsNumbers='" + tramsNumbers + '\'' +
                ", metrosNumbers='" + metrosNumbers + '\'' +
                ", electricTrainsNumbers='" + electricTrainsNumbers + '\'' +
                ", riverTransportsNumbers='" + riverTransportsNumbers + '\'' +
                '}';
    }

    public int getStopID() {
        return stopID;
    }

    public String getAdjacentStreet() {
        return adjacentStreet;
    }

    public String getDirection() {
        return direction;
    }

    public String getBusNumbers() {
        return busNumbers;
    }

    public String getTramsNumbers() {
        return tramsNumbers;
    }

    public String getTrolleybusesNumbers() {
        return trolleybusesNumbers;
    }

    public String getMetrosNumbers() {
        return metrosNumbers;
    }

    public String getElectricTrainsNumbers() {
        return electricTrainsNumbers;
    }

    public String getRiverTransportsNumbers() {
        return riverTransportsNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stop stop = (Stop) o;
        return stopID == stop.stopID && Objects.equals(title, stop.title) && Objects.equals(adjacentStreet, stop.adjacentStreet) && Objects.equals(direction, stop.direction) && Objects.equals(busNumbers, stop.busNumbers) && Objects.equals(tramsNumbers, stop.tramsNumbers) && Objects.equals(trolleybusesNumbers, stop.trolleybusesNumbers) && Objects.equals(metrosNumbers, stop.metrosNumbers) && Objects.equals(electricTrainsNumbers, stop.electricTrainsNumbers) && Objects.equals(riverTransportsNumbers, stop.riverTransportsNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stopID, title, adjacentStreet, direction, busNumbers, tramsNumbers, trolleybusesNumbers, metrosNumbers, electricTrainsNumbers, riverTransportsNumbers);
    }
}
