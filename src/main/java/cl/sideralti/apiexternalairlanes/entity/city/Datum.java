package cl.sideralti.apiexternalairlanes.entity.city;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Datum {

    @JsonProperty("country")
    private Boolean country;

    @JsonProperty("city")
    private String city;

    @JsonProperty("populationCounts")
    private List<PopulationCount> populationCounts = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
}
