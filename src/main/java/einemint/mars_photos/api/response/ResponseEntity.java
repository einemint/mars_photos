package einemint.mars_photos.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class ResponseEntity {
    @Setter
    @Getter
    ArrayList<Photo> photos;

    public ResponseEntity() {
        photos = new ArrayList<>();
    }

    public ResponseEntity(ArrayList<Photo> photos) {
        this.photos = photos;
    }
}
