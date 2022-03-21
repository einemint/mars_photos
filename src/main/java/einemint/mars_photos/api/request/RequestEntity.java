package einemint.mars_photos.api.request;

import lombok.Data;

@Data
public class RequestEntity {
    private final String MAIN_URL = "https://api.nasa.gov/mars-photos/api/v1";

    private String rover = "curiosity";
    private String earthDate = "2015-6-3";
    private String camera = "FHAZ";
    private String apiKey = "DEMO_KEY";

    public String toString() {
        return MAIN_URL + "/rovers/" + rover
                + "/photos?earth_date=" + earthDate
                + "&camera=" + camera
                + "&api_key=" + apiKey;
    }
}
