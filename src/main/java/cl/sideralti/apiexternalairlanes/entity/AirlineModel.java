package cl.sideralti.apiexternalairlanes.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AirlineModel implements Serializable {
    private long id;
    private String name;
    private String country;
    private String logo;
    private String slogan;
    private String head_quaters;
    private String website;
    private String established;
}
