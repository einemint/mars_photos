package einemint.mars_photos.api.response;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "photos")
public class Photo {
    @Id
    private int id;
    private int sol;
    private int camera_id;
    private String img_src;
    private String earth_date;
    private int rover_id;
}
