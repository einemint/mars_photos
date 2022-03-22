package einemint.mars_photos;

import einemint.mars_photos.api.request.Request;
import einemint.mars_photos.service.WebClientService;
import einemint.mars_photos.service.WritePhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarsPhotosApplication {
	@Autowired
	public static WritePhotosService writePhotosService;
	@Autowired
	public static WebClientService webClientService;
	@Autowired
	public static Request request;

	public static void main(String[] args) {
		SpringApplication.run(MarsPhotosApplication.class, args);

		webClientService.addPhotosToDatabase(webClientService.getPhotosWithParameters(request));
		writePhotosService.writeImagesToFiles();
	}
}
