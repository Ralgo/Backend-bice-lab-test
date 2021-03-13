package cl.bice.lab.indecon.client.rest.impl;

import cl.bice.lab.indecon.dto.IndeconLastValuesResponseDto;
import cl.bice.lab.indecon.dto.IndeconValueDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;

/**
 * @author Cristian Beroiza <cberoiza AT gmail DOT com> 12-03-21
 */
class IndeconRestClientImplTest {

    public static MockWebServer mockWebServer;

    private final IndeconRestClientImpl indeconRestClient;
    private IndeconLastValuesResponseDto indeconLastValuesResponseDtoMock;

    IndeconRestClientImplTest() {
        this.indeconRestClient = new IndeconRestClientImpl();
    }

    @BeforeAll
    static void beforeAll() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @BeforeEach
    void setUp() {
        String baseUrl = String.format("http://localhost:%s", mockWebServer.getPort());
        ReflectionTestUtils.setField(indeconRestClient, "indeconSiteUrl", baseUrl);

        IndeconValueDto cobre = IndeconValueDto.builder()
                .key("Cobre")
                .date("123456789")
                .name("Valor del cobre")
                .unit("Dolar")
                .value(2.2)
                .build();

        IndeconValueDto oro = IndeconValueDto.builder()
                .key("Oro")
                .date("123456789")
                .name("Valor del oro")
                .unit("Dolar")
                .value(12.2)
                .build();

        indeconLastValuesResponseDtoMock = IndeconLastValuesResponseDto.builder()
                .cobre(cobre)
                .oro(oro)
                .build();
    }

    @Test
    void lastService() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        mockWebServer.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(indeconLastValuesResponseDtoMock))
                .addHeader("Content-Type", "application/json"));

        Mono<IndeconLastValuesResponseDto> responseDtoMono = indeconRestClient.lastService();

        StepVerifier.create(responseDtoMono)
                .expectNextMatches(indeconLastValuesResponseDto ->
                        indeconLastValuesResponseDto.getCobre().getValue() == 2.2)
                .verifyComplete();
    }
}