package einemint.mars_photos;

import einemint.mars_photos.api.request.RequestEntity;
import einemint.mars_photos.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarsPhotosApplication {
	@Autowired
	public static WebClientService webClientService;

	public static void main(String[] args) {
		SpringApplication.run(MarsPhotosApplication.class, args);
		webClientService.addPhotos(webClientService.getPhotosWithParameters(new RequestEntity()));
	}

}
