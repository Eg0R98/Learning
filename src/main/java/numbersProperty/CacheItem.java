package numbersProperty;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.Instant;

@JsonAutoDetect
public class CacheItem {
    private Instant instantStart;
    private String documentStr;

    public CacheItem(String documentStr) {
        this.instantStart = Instant.now();
        this.documentStr = documentStr;
    }

    public CacheItem() {
    }


    public Instant getInstantStart() {
        return instantStart;
    }

    public String getDocumentStr() {
        return documentStr;
    }
}
