package cl.sideralti.apiexternalairlanes.entity;

import lombok.Data;

@Data
public class AirlineModel {
    private long id;
    private String name;
    private String country;
    private String logo;
    private String slogan;
    private String head_quaters;
    private String website;
    private String established;
}
