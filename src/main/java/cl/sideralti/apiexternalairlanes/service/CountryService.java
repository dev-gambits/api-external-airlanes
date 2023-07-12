package cl.sideralti.apiexternalairlanes.service;

import cl.sideralti.apiexternalairlanes.entity.city.DataModel;
import cl.sideralti.apiexternalairlanes.exception.BadRequestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CountryService {

    @Autowired
    WebClient webClient;

    private static final Logger logger = LogManager.getLogger(CountryService.class);

    public Flux<DataModel> getCitiesRetrieve() {
        return webClient
                .get()
                .uri("https://countriesnow.space/api/v0.1/countries/population/cities")
                .retrieve()
                .onStatus(HttpStatusCode::isError,
                        response -> switch (response.rawStatusCode()){
                            case 400 -> Mono.error(new BadRequestException("bad request made"));
                            case 401, 403 -> Mono.error(new Exception("auth error"));
                            case 500 -> Mono.error(new Exception("server error"));
                            default -> Mono.error(new Exception("something went wrong"));
                        })
                .bodyToFlux(DataModel.class)

                .doOnError(throwable -> logger.error("Failed for some reason", throwable));
    }

    public Flux<DataModel> getCitiesRetrieve2() {
        return webClient
                .get()
                .uri("https://api.instantwebtools.net/v1/airlines")
                .retrieve()
                .onStatus(HttpStatusCode::isError,
                        response -> switch (response.rawStatusCode()){
                            case 400 -> Mono.error(new BadRequestException("bad request made"));
                            case 401, 403 -> Mono.error(new Exception("auth error"));
                            case 500 -> Mono.error(new Exception("server error"));
                            default -> Mono.error(new Exception("something went wrong"));
                        })
                .bodyToFlux(DataModel.class)
                .doOnError(throwable -> logger.error("Failed for some reason", throwable));

    }

}
