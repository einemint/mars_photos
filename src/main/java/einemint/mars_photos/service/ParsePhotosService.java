package einemint.mars_photos.service;

import einemint.mars_photos.model.Camera;
import einemint.mars_photos.model.Photo;
import einemint.mars_photos.model.Photos;
import einemint.mars_photos.model.Rover;
import einemint.mars_photos.repository.CameraRepository;
import einemint.mars_photos.repository.PhotoRepository;
import einemint.mars_photos.repository.RoverRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Log4j2
public class ParsePhotosService {
    private String uri;

    @Value("${application.main_url}")
    private String mainUrl;
    @Value("${application.rover}")
    private String rover;
    @Value("${application.earth_date}")
    private String earthDate;
    @Value("${application.camera}")
    private String camera;
    @Value("${application.api_key}")
    private String apiKey;

    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private CameraRepository cameraRepository;
    @Autowired
    private RoverRepository roverRepository;
    @Autowired
    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        this.uri = mainUrl + "/rovers/" + rover
                + "/photos?earth_date=" + earthDate
                + "&camera=" + camera
                + "&api_key=" + apiKey;
    }

    public void addPhotosToDatabase() {
        Photos photos = restTemplate.getForObject(uri, Photos.class);

        for (Photo photo : photos.getPhotos()) {
            photo.setCameraId(addCamera(photos));
            photo.setCameraId(addRover(photos));
            photoRepository.save(photo);
        }
    }

    private int addCamera(Photos photos) {
        Camera camera = new Camera();

        for (Photo photo : photos.getPhotos()) {
            camera = photo.getCamera();
            cameraRepository.save(camera);
        }

        return camera.getId();
    }

    private int addRover(Photos photos) {
        Rover rover = new Rover();

        for (Photo photo : photos.getPhotos()) {
            rover = photo.getRover();
            roverRepository.save(rover);
        }

        return rover.getId();
    }
}
