package einemint.mars_photos.config;

import einemint.mars_photos.service.ParsePhotosService;
import einemint.mars_photos.service.WritePhotosService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) { return builder.build(); }

    @Bean(initMethod = "addPhotosToDatabase")
    public ParsePhotosService parsePhotosService() {
        return new ParsePhotosService();
    }

    @Bean(initMethod = "writeImagesToFiles")
    public WritePhotosService writePhotosService() { return new WritePhotosService(); }
}
