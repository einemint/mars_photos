package einemint.mars_photos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Entity
@Table(name = "photos")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {
    @Id
    private int id;
    private int sol;
    private int cameraId;
    @JsonProperty("img_src")
    private String imgSrc;
    @JsonProperty("earth_date")
    private String earthDate;
    private int roverId;

    @Transient
    private Camera camera;
    @Transient
    private Rover rover;
}
