package einemint.mars_photos.api.response;

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
    private String landing_date;
    private String launch_date;
    private String status;
}
