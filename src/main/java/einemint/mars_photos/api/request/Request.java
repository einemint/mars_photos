package einemint.mars_photos.api.request;

import einemint.mars_photos.config.ApplicationConfiguration;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Request {
    private final String MAIN_URL = "https://api.nasa.gov/mars-photos/api/v1";

    @Autowired
    private ApplicationConfiguration configuration;

    private String rover = configuration.getRover();
    private String earthDate = configuration.getEarth_date();
    private String camera = configuration.getCamera();
    private String apiKey = configuration.getApi_key();

    public String toString() {
        return MAIN_URL + "/rovers/" + rover
                + "/photos?earth_date=" + earthDate
                + "&camera=" + camera
                + "&api_key=" + apiKey;
    }
}
