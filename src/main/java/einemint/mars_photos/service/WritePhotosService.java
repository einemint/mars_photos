package einemint.mars_photos.service;

import einemint.mars_photos.repository.PhotoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Log4j2
public class WritePhotosService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PhotoRepository photoRepository;

    private byte[] getImage(String imageUrl) {
        return restTemplate.getForObject(imageUrl, byte[].class);
    }

    private void writeImage(byte[] image, String name) {
        try {
            Files.write(Paths.get("data/" + name) , image);
        }
        catch (Exception exception) {
            log.warn(exception.getStackTrace());
        }
    }

    public void writeImagesToFiles() {
        List<String> imagesSources = photoRepository.findImagesSources();
        String[] linkArray;
        String name;

        for (String imageSource : imagesSources) {
            linkArray = imageSource.split("/");
            name = linkArray[linkArray.length-1];

            writeImage(getImage(imageSource), name);
        }
    }
}
