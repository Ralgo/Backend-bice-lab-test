package cl.bice.lab.indecon.service.impl;

import cl.bice.lab.indecon.client.rest.IndeconRestClient;
import cl.bice.lab.indecon.dto.IndeconLastValuesResponseDto;
import cl.bice.lab.indecon.service.IndeconService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return indeconRestClient.lastService();
    }
}
