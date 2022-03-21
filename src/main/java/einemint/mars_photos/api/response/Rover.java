package einemint.mars_photos.api.response;

import lombok.Data;

@Data
public class Rover {
    private int id;
    private String name;
    private String landingDate;
    private String launchDate;
    private String status;
}
