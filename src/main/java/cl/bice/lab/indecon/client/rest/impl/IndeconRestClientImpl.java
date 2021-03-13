package cl.bice.lab.indecon.client.rest.impl;

import cl.bice.lab.indecon.client.rest.IndeconRestClient;
import cl.bice.lab.indecon.dto.IndeconLastValuesResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

/**
 * @author Cristian Beroiza <cberoiza AT gmail DOT com> 11-03-21
 */
@Slf4j
@Component
public class IndeconRestClientImpl implements IndeconRestClient {

    @Value("${indecon.site.url}")
    private String indeconSiteUrl;

    @Override
    public Mono<IndeconLastValuesResponseDto> lastService() {
        log.debug("Lets call the external Indecon rest endpoint using webclient!!!");

        WebClient webClient = WebClient.builder()
                .baseUrl(indeconSiteUrl)
                .clientConnector(new ReactorClientHttpConnector(
                        HttpClient.create().followRedirect(true) // this is 'cause the Indecon api was throwing a 301 http response
                ))
                .build();

        return webClient.get()
                .uri("/last")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(IndeconLastValuesResponseDto.class);
    }
}
