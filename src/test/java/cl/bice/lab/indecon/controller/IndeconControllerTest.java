package cl.bice.lab.indecon.controller;

import cl.bice.lab.indecon.dto.IndeconLastValuesResponseDto;
import cl.bice.lab.indecon.dto.IndeconValueDto;
import cl.bice.lab.indecon.service.IndeconService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Cristian Beroiza <cberoiza AT gmail DOT com> 12-03-21
 */
class IndeconControllerTest {

    private final MockMvc mockMvc;
    private final IndeconService indeconService;

    private IndeconLastValuesResponseDto indeconLastValuesResponseDtoMock;

    IndeconControllerTest() {
        this.indeconService = mock(IndeconService.class);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new IndeconController(indeconService)).build();
    }

    @BeforeEach
    void init() {
        List<IndeconValueDto> indeconValueDtoList = new ArrayList<>();

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

        indeconValueDtoList.add(oro);
        indeconValueDtoList.add(cobre);

        indeconLastValuesResponseDtoMock = IndeconLastValuesResponseDto.builder()
                .indeconValueDtoList(indeconValueDtoList)
                .build();
    }


    @Test
    void whenGetLastValues_shouldReturnValidValues() throws Exception {
        given(indeconService.getLastValues()).willReturn(indeconLastValuesResponseDtoMock);

        mockMvc.perform(get("/indecon/"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}