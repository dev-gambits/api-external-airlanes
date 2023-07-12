package cl.sideralti.apiexternalairlanes.entity.city;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class PopulationCount implements Serializable {

    @JsonProperty("year")
    private Boolean year;

    @JsonProperty("value")
    private String value;

    @JsonProperty("sex")
    private String sex;

    @JsonProperty("reliabilty")
    private String reliabilty;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
}
