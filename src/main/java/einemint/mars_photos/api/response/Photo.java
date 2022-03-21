package einemint.mars_photos.api.response;

import lombok.Data;

@Data
public class Photo {
    private int id;
    private int sol;
    private Camera camera;
    private String imgSrc;
    private String earthDate;
    private Rover rover;
}
