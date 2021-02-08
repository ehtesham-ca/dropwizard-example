package NLPService.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SampleResponseObj {
    private long id;

    private String content;

    public SampleResponseObj() {
        // Jackson deserialization
    }

    public SampleResponseObj(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "SampleRequestObj{" + "id=" + id + ", content='" + content + '\'' + '}';
    }
}

