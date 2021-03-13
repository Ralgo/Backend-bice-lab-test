package cl.bice.lab.indecon.service;

import cl.bice.lab.indecon.dto.IndeconLastValuesResponseDto;

/**
 * @author Cristian Beroiza <cberoiza AT gmail DOT com> 11-03-21
 */
public interface IndeconService {

    IndeconLastValuesResponseDto getLastValues();

}
