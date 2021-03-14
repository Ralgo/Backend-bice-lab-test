package cl.bice.lab.indecon.service.impl;

import cl.bice.lab.indecon.client.rest.IndeconRestClient;
import cl.bice.lab.indecon.dto.IndeconLastValuesDto;
import cl.bice.lab.indecon.dto.IndeconLastValuesResponseDto;
import cl.bice.lab.indecon.dto.IndeconValueDto;
import cl.bice.lab.indecon.service.IndeconService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cristian Beroiza <cberoiza AT gmail DOT com> 11-03-21
 */
@Slf4j
@Service
public class IndeconServiceImpl implements IndeconService {

    private final IndeconRestClient indeconRestClient;

    @Autowired
    public IndeconServiceImpl(IndeconRestClient indeconRestClient) {
        this.indeconRestClient = indeconRestClient;
    }

    @Override
    public IndeconLastValuesResponseDto getLastValues() {
        log.debug("Invoking WebClient Indecon Last Values Service");
        Mono<IndeconLastValuesDto> indeconLastValuesResponseDtoMono = indeconRestClient.lastService();
        IndeconLastValuesDto indeconLastValuesDto = indeconLastValuesResponseDtoMono.block();

        List<IndeconValueDto> indeconValueDtoList = null;
        if (indeconLastValuesDto != null) {
            indeconValueDtoList = mapIndeconLastValuesDto(indeconLastValuesDto);
        }

        return IndeconLastValuesResponseDto.builder()
                .indeconValueDtoList(indeconValueDtoList)
                .build();
    }

    private List<IndeconValueDto> mapIndeconLastValuesDto(IndeconLastValuesDto indeconLastValuesDto) {
        List<IndeconValueDto> indeconValueDtoList = new ArrayList<>();
        indeconValueDtoList.add(indeconLastValuesDto.getCobre());
        indeconValueDtoList.add(indeconLastValuesDto.getDolar());
        indeconValueDtoList.add(indeconLastValuesDto.getEuro());
        indeconValueDtoList.add(indeconLastValuesDto.getIpc());
        indeconValueDtoList.add(indeconLastValuesDto.getIvp());
        indeconValueDtoList.add(indeconLastValuesDto.getOro());
        indeconValueDtoList.add(indeconLastValuesDto.getPlata());
        indeconValueDtoList.add(indeconLastValuesDto.getUf());
        indeconValueDtoList.add(indeconLastValuesDto.getUtm());
        indeconValueDtoList.add(indeconLastValuesDto.getYen());
        return indeconValueDtoList;
    }
}
