package cl.bice.lab.indecon.service.impl;

import cl.bice.lab.indecon.client.rest.IndeconRestClient;
import cl.bice.lab.indecon.dto.IndeconLastValuesResponseDto;
import cl.bice.lab.indecon.dto.IndeconValueDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Cristian Beroiza <cberoiza AT gmail DOT com> 12-03-21
 */
class IndeconServiceImplTest {

    private final IndeconRestClient indeconRestClient;
    private final IndeconServiceImpl indeconService;

    private IndeconLastValuesResponseDto indeconLastValuesResponseDtoMock;

    IndeconServiceImplTest() {
        indeconRestClient = mock(IndeconRestClient.class);
        indeconService = new IndeconServiceImpl(indeconRestClient);
    }

    @BeforeEach
    void setUp() {
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
    void whenGetLastValues_shouldReturnValidValues() {
        when(indeconRestClient.lastService()).thenReturn(Mono.just(indeconLastValuesResponseDtoMock));

        IndeconLastValuesResponseDto indeconLastValuesResponseDto = indeconService.getLastValues();

        assertNotNull(indeconLastValuesResponseDto);
        assertEquals(2.2, indeconLastValuesResponseDto.getCobre().getValue());
    }
}