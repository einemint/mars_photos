package einemint.mars_photos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import einemint.mars_photos.api.request.Request;
import einemint.mars_photos.api.response.Camera;
import einemint.mars_photos.api.response.Photo;
import einemint.mars_photos.api.response.Rover;
import einemint.mars_photos.repository.CameraRepository;
import einemint.mars_photos.repository.PhotoRepository;
import einemint.mars_photos.repository.RoverRepository;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Log4j2
public class WebClientService {
    private final String OBJECTS_KEY = "photos";
    private final String CAMERA_KEY = "camera";
    private final String ROVER_KEY = "rover";

    @Autowired
    private WebClient webClient;
    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private CameraRepository cameraRepository;
    @Autowired
    private RoverRepository roverRepository;

    public String getPhotosWithParameters(Request request) {
        return webClient.get()
                .uri(request.toString())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public void addPhotosToDatabase(String response) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray objects = jsonObject.getJSONArray(OBJECTS_KEY);

            for (int counter = 0; counter < objects.length(); counter++) {
                JSONObject object = objects.getJSONObject(counter);

                Photo photo = new Photo();
                photo.setId(Integer.parseInt(object.get("id").toString()));
                photo.setSol(Integer.parseInt(object.get("sol").toString()));
                photo.setCamera_id(addCamera(response));
                photo.setImg_src(object.get("img_src").toString());
                photo.setEarth_date(object.get("earth_date").toString());
                photo.setCamera_id(addRover(response));
                photoRepository.save(photo);
            }
        }catch (Exception exception){
            exception.printStackTrace();
            log.warn(exception.getStackTrace());
        }
    }

    private int addCamera(String response) {
        Camera camera = new Camera();
        ObjectMapper mapper = new ObjectMapper();

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray objects = jsonObject.getJSONArray(OBJECTS_KEY);

            JSONObject object = objects.getJSONObject(0);
            camera = mapper.readValue(object.get(CAMERA_KEY).toString(), Camera.class);
            cameraRepository.save(camera);

        }catch (Exception exception){
            exception.printStackTrace();
            log.warn(exception.getStackTrace());
        }

        return camera.getId();
    }

    private int addRover(String response) {
        Rover rover = new Rover();
        ObjectMapper mapper = new ObjectMapper();

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray objects = jsonObject.getJSONArray(OBJECTS_KEY);

            JSONObject object = objects.getJSONObject(0);
            rover = mapper.readValue(object.get(ROVER_KEY).toString(), Rover.class);
            roverRepository.save(rover);

        }catch (Exception exception){
            exception.printStackTrace();
            log.warn(exception.getStackTrace());
        }

        return rover.getId();
    }
}
