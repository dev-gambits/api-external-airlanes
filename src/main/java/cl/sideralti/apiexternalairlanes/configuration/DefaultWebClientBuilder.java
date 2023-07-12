package cl.sideralti.apiexternalairlanes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Configuration
public class DefaultWebClientBuilder {

    @Bean
    public void DefaultWebClientBuilder() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8089")
                .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8089"))
                .build();
    }
}
