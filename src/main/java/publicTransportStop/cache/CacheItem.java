package publicTransportStop.cache;

import java.time.Instant;

public class CacheItem {
    private Instant instantStart;
    private String documentStr;

    CacheItem(String documentStr) {
        this.instantStart = Instant.now();
        this.documentStr = documentStr;
    }

    public Instant getInstantStart() {
        return instantStart;
    }

    public String getDocumentStr() {
        return documentStr;
    }

    public void setDocumentStr(String documentStr) {
        this.documentStr = documentStr;
    }

}
