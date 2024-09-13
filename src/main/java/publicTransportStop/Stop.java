package publicTransportStop;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Objects;


@XmlRootElement(name = "stop")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stop {
    @XmlElement(name = "KS_ID")
    private int stopID;

    private String title;

    private String adjacentStreet;

    private String direction;

    private String busesMunicipal;

    private String busesCommercial;

    private String busesPrigorod;

    private String busesSeason;

    private String busesSpecial;

    private String busesIntercity;

    private String trolleybuses;

    private String trams;

    private String metros;

    private String electricTrains;

    private String riverTransports;

    public Stop(int stopID, String title, String adjacentStreet, String direction, String busesMunicipal,
                String busesCommercial, String busesPrigorod, String busesSeason, String busesSpecial,
                String busesIntercity, String trolleybuses, String trams, String metros,
                String electricTrains, String riverTransports) {
        this.stopID = stopID;
        this.title = title;
        this.adjacentStreet = adjacentStreet;
        this.direction = direction;
        this.busesMunicipal = busesMunicipal;
        this.busesCommercial = busesCommercial;
        this.busesPrigorod = busesPrigorod;
        this.busesSeason = busesSeason;
        this.busesSpecial = busesSpecial;
        this.busesIntercity = busesIntercity;
        this.trolleybuses = trolleybuses;
        this.trams = trams;
        this.metros = metros;
        this.electricTrains = electricTrains;
        this.riverTransports = riverTransports;
    }

    public Stop() {
    }

    public String getBuses() {
        StringBuilder builder = new StringBuilder();
        if (!this.busesMunicipal.isEmpty()) builder.append(this.busesMunicipal).append(", ");
        if (!this.busesCommercial.isEmpty()) builder.append(this.busesCommercial).append(", ");
        if (!this.busesCommercial.isEmpty()) builder.append(this.busesCommercial).append(", ");
        if (!this.busesSeason.isEmpty()) builder.append(this.busesSeason).append(", ");
        if (!this.busesIntercity.isEmpty()) builder.append(this.busesIntercity).append(", ");
        if (!builder.isEmpty()) builder.delete(builder.length() - 2, builder.length() - 1);

        return builder.toString();
    }

    public boolean isEmpty() {
        return this.getBuses().isEmpty() && this.trolleybuses.isEmpty()
                && this.trams.isEmpty() && this.electricTrains.isEmpty()
                && this.riverTransports.isEmpty() && this.metros.isEmpty();
    }

    public static String createFullStopTitle(Stop stop, int index) {
        return String.format("%s. %s %s %s", index, stop.title, stop.adjacentStreet, stop.direction);
    }


    @Override
    public String toString() {
        return "Stop{" +
                "stopID=" + stopID +
                ", title='" + title + '\'' +
                ", adjacentStreet='" + adjacentStreet + '\'' +
                ", direction='" + direction + '\'' +
                ", busesMunicipal='" + busesMunicipal + '\'' +
                ", busesCommercial='" + busesCommercial + '\'' +
                ", busesPrigorod='" + busesPrigorod + '\'' +
                ", busesSeason='" + busesSeason + '\'' +
                ", busesSpecial='" + busesSpecial + '\'' +
                ", busesIntercity='" + busesIntercity + '\'' +
                ", trolleybuses='" + trolleybuses + '\'' +
                ", trams='" + trams + '\'' +
                ", metros='" + metros + '\'' +
                ", electricTrains='" + electricTrains + '\'' +
                ", riverTransports='" + riverTransports + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public int getStopID() {
        return stopID;
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
