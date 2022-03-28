package einemint.mars_photos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cameras")
@AllArgsConstructor
@NoArgsConstructor
public class Camera {
    @Id
    private int id;
    private String name;
    @JsonProperty("rover_id")
    private int roverId;
    @JsonProperty("full_name")
    private String fullName;
}
