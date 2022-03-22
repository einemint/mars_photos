package einemint.mars_photos.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationConfiguration {
    @Setter
    @Getter
    private String rover;
    @Setter
    @Getter
    private String earth_date;
    @Setter
    @Getter
    private String camera;
    @Setter
    @Getter
    private String api_key;

    @Bean
    public WebClient webClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .build();
    }
}
