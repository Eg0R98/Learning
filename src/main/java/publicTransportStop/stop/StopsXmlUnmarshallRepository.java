package publicTransportStop.stop;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "stops")
@XmlAccessorType(XmlAccessType.FIELD)
public class StopsXmlUnmarshallRepository {
    @XmlElement(name = "stop")
    private List<StopXmlUnmarshall> listStopXmlUnmarshall = new ArrayList<>();

    public List<StopXmlUnmarshall> getListStopXmlUnmarshall() {
        return listStopXmlUnmarshall;
    }
}
