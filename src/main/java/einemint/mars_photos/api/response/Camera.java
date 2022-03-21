package einemint.mars_photos.api.response;

import lombok.Data;

@Data
public class Camera {
    private int id;
    private String name;
    private int roverId;
    private String fullName;
}
