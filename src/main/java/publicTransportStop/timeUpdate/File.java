package publicTransportStop.timeUpdate;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "file")
@XmlAccessorType(XmlAccessType.FIELD)
public class File {
    @XmlAttribute
    private String name;
    @XmlElement
    private Double modified;

    public String getName() {
        return name;
    }

    public Double getModified() {
        return modified;
    }
}
