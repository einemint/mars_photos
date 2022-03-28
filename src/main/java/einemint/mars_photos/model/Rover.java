package einemint.mars_photos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "rovers")
public class Rover {
    @Id
    private int id;
    private String name;
    @JsonProperty("landing_date")
    private String landingDate;
    @JsonProperty("launch_date")
    private String launchDate;
    private String status;
}
