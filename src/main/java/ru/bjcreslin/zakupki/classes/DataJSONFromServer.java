package ru.bjcreslin.zakupki.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "totalpages",
        "currpage",
        "totalrecords",
        "invdata"
})
public class DataJSONFromServer {

    @JsonProperty("totalpages")
    public Integer totalpages;
    @JsonProperty("currpage")
    public Integer currpage;
    @JsonProperty("totalrecords")
    public Integer totalrecords;
    @JsonProperty("invdata")
    public List<Invdatum> invdata = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "DataJSONFromServer{" +
                "totalpages=" + totalpages +
                ", currpage=" + currpage +
                ", totalrecords=" + totalrecords +
                ", invdata=" + invdata +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}


