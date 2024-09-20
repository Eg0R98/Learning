package publicTransportStop.stop;

import publicTransportStop.exceptions.NotMatchException;

import java.util.ArrayList;
import java.util.List;

public class Stops {
    private static List<Stop> listStops = new ArrayList<>();

    public static List<Stop> getMatches(String title) throws NotMatchException {
        String titleIgnoreCase = title.toLowerCase();
        List<Stop> list = new ArrayList<>();
        for (Stop s : listStops) {
            if (s.isThereACompleteLackOfPublicTransport()) {
                continue;
            }
            if (s.getTitle().toLowerCase().contains(titleIgnoreCase)) {
                list.add(s);
            }
        }
        if (list.isEmpty()) throw new NotMatchException("Ошибка. Совпадений не найдено");
        return list;
    }

    public static Integer getStopID(Stop stop) {
        return stop.getStopID();
    }

    public static List<Stop> getListStops() {
        return listStops;
    }

    public static void setListStops(List<Stop> listStops) {
        Stops.listStops = listStops;
    }
}
