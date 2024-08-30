package publicTransportStop;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StopRepository {
    private static List<Stop> listStop;

    public static void setListStop(List<Stop> listStop) {
        StopRepository.listStop = listStop;
    }

    public static Map<Integer, Stop> getMatches(String title) throws NotMatchException {
        String titleIgnoreCase = title.toLowerCase();
        int count = 1;
        Map<Integer, Stop> matches = new TreeMap<>();
        for (Stop s : listStop) {
            if (s.getBusNumbers().isEmpty() && s.getTrolleybusesNumbers().isEmpty()
                    && s.getTramsNumbers().isEmpty() && s.getElectricTrainsNumbers().isEmpty()
                    && s.getRiverTransportsNumbers().isEmpty() && s.getMetrosNumbers().isEmpty()) {
                continue;
            }
            if (s.getTitle().toLowerCase().contains(titleIgnoreCase)) {
                matches.put(count, s);
                count++;
            }
        }
        if (matches.isEmpty()) throw new NotMatchException("Ошибка. Совпадений не найдено");
        return matches;
    }

    public static Integer getStopID(Stop stop) {
        return stop.getStopID();
    }


    public static List<Stop> getListStop() {
        return listStop;
    }

}
