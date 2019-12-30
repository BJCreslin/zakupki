package ru.bjcreslin.zakupki.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.extern.java.Log;

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
@Log
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
    private Map<String, Object> additionalProperties = new HashMap<>();

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

    public void logObject() {
        log.info("Всего данных на сервере: " + this.totalrecords + ", всего на " + this.totalpages + " страниц. Текущая страница: " + this.currpage + " .");
        for (int i = 0; i < this.invdata.size(); i++) {
            log.info("Answer Purchase " + this.invdata.get(i).toString());
        }

    }
}


