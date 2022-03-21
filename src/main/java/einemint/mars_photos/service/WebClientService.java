package einemint.mars_photos.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import einemint.mars_photos.api.request.RequestEntity;
import einemint.mars_photos.api.response.Photo;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;

@Service
@Log4j2
public class WebClientService {
    private final String OBJECTS_KEY = "photos";
    private final WebClient WEB_CLIENT = WebClient.create();

    public String getPhotosWithParameters(RequestEntity request) {
        return WEB_CLIENT.get()
                .uri(request.toString())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public ArrayList<Photo> getPhotos(String response) {
        ArrayList<Photo> photos = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray objects = jsonObject.getJSONArray(OBJECTS_KEY);

            for (Object object: objects) {
                Photo photo = mapper.convertValue(object, Photo.class);
                photos.add(photo);
            }
        }catch (Exception exception){
            exception.printStackTrace();
            log.warn(exception.getStackTrace());
        }

        return photos;
    }
}
