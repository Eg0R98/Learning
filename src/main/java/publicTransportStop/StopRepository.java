package publicTransportStop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StopRepository {
    private static Map<String, Integer> map;

    public static Map<String, Integer> getMap() {
        return map;
    }

    public static void setMap(Map<String, Integer> map) {
        StopRepository.map = map;
    }

    public static List<String> getMatches(String title) throws NotMatchException {
        String titleIgnoreCase = title.toLowerCase();
        int count = 1;
        List<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            boolean b = s.toLowerCase().contains(titleIgnoreCase);
            if (b) {
                String stop = String.format("%d. %s", count, s);
                list.add(stop);
                count++;
            }
        }
        if (list.isEmpty()) throw new NotMatchException("Ошибка. Совпадений не найдено");
        return list;
    }

    public static Integer getStopID(String title) {
        return map.get(title);
    }

    public static String getTitleWithDirection(String numberOfMatch, List<String> matches) throws NotMatchException {
        String result = null;
        for (String s : matches) {
            if (s.startsWith(numberOfMatch)) {
                int index = s.indexOf(" ");
                result = s.substring(index + 1);
            }
        }
        System.out.println();
        if (result == null) throw new NotMatchException("Такого номера в списке нет, либо допущена иная ошибка ввода");
        return result;
    }

}
