package publicTransportStop.stop;

import java.util.ArrayList;
import java.util.List;

public class ConvertingStopXmlUnmarshallToStop {
    public static List<Stop> convert(List<StopXmlUnmarshall> listStopXmlUnmarshall) {
        List<Stop> listStop = new ArrayList<>();
        for (StopXmlUnmarshall sxu : listStopXmlUnmarshall) {
            Stop stop = new Stop(sxu.getStopID(), sxu.getTitle(), sxu.getAdjacentStreet(), sxu.getDirection(), sxu.getBuses(),
                    sxu.getTrolleybuses(), sxu.getTrams(), sxu.getMetros(), sxu.getElectricTrains(), sxu.getRiverTransports());
            listStop.add(stop);
        }
        return listStop;
    }


}
