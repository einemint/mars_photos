package einemint.mars_photos;

import einemint.mars_photos.model.Camera;
import einemint.mars_photos.model.Photo;
import einemint.mars_photos.model.Rover;
import einemint.mars_photos.service.ParsePhotosService;
import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ParsePhotosServiceTest extends TestCase {
    @Autowired
    private ParsePhotosService parsePhotosService;

    private Camera camera = new Camera(20, "FHAZ", 5, "Front Hazard Avoidance Camera");
    private Rover rover = new Rover(5, "Curiosity", "2012-08-06", "2011-11-26", "active");
    private Photo photo = new Photo();

    @Test
    @DisplayName("Некорректное добавление камеры в базу данных")
    public void addCameraTest() {
        photo.setCamera(camera);
        photo.setRover(rover);

        int expectedCameraId = parsePhotosService.addCamera(photo);

        assertEquals(camera.getId(), expectedCameraId);
    }

    @Test
    @DisplayName("Некорректное добавление ровера в базу данных")
    public void addRoverTest() {
        photo.setCamera(camera);
        photo.setRover(rover);

        int expectedRoverId = parsePhotosService.addRover(photo);

        assertEquals(rover.getId(), expectedRoverId);
    }
}
