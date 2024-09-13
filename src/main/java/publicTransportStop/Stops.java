package publicTransportStop;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "stops")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stops {
    @XmlElement(name = "stop")
    private List<Stop> listStop;


    public List<Stop> getMatches(String title) throws NotMatchException {
        String titleIgnoreCase = title.toLowerCase();
        List<Stop> list = new ArrayList<>();
        for (Stop s : this.listStop) {
            if (s.isEmpty()) {
                continue;
            }
            if (s.getTitle().toLowerCase().contains(titleIgnoreCase)) {
                list.add(s);
            }
        }
        if (list.isEmpty()) throw new NotMatchException("Ошибка. Совпадений не найдено");
        return list;
    }

    public List<Stop> getListStop() {
        return listStop;
    }

    public static Integer getStopID(Stop stop) {
        return stop.getStopID();
    }

//    public static List<Instant> getTimeUpdateStopslist() {
//        return timeUpdateStopslist;
//    }
//
//    public static void setTimeUpdateStopslist(List<Instant> timeUpdateStoplist) {
//        Stops.timeUpdateStopslist = timeUpdateStoplist;
//    }
}
