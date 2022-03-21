package einemint.mars_photos.api.response;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cameras")
public class Camera {
    @Id
    private int id;
    private String name;
    private int rover_id;
    private String full_name;
}
