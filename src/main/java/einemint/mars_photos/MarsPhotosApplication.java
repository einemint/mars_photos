package einemint.mars_photos;

import einemint.mars_photos.api.request.RequestEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarsPhotosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsPhotosApplication.class, args);
		RequestEntity requestEntity = new RequestEntity();
	}

}
