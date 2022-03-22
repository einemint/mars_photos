package einemint.mars_photos.service;

import einemint.mars_photos.api.response.Photo;
import einemint.mars_photos.repository.PhotoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@Log4j2
public class WritePhotosService {
    @Autowired
    private WebClient webClient;
    @Autowired
    private PhotoRepository photoRepository;

    public byte[] getImage(String link) {
        return webClient.get()
                .uri(link)
                .accept(MediaType.IMAGE_JPEG)
                .retrieve()
                .bodyToMono(byte[].class)
                .block();
    }

    public void writeImage(byte[] image, String name) {
        try {
            Files.write(Paths.get("data/" + name) , image);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            log.warn(exception.getStackTrace());
        }
    }

    public void writeImagesToFiles() {
        Iterable<Photo> photos = photoRepository.findAll();
        String link;
        String[] linkArray;
        String name;

        for (Photo photo : photos) {
            link = photo.getImg_src();
            linkArray = link.split("/");
            name = linkArray[linkArray.length-1];

            writeImage(getImage(link), name);
        }
    }
}
