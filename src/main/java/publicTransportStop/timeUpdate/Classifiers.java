package publicTransportStop.timeUpdate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "classifiers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Classifiers {
    @XmlElement(name = "file")
    private static List<File> filesWithTimeUpdate = new ArrayList<>();

    public static Double getNewTimeUpdate() {
        Double d = null;
        for (File file : filesWithTimeUpdate) {
            if (file.getName().equals("stopsFullDB.xml")) {
                d = file.getModified();
                break;
            }
        }
        return d;
    }
}
