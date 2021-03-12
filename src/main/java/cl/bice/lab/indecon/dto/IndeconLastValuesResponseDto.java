package cl.bice.lab.indecon.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Cristian Beroiza <cberoiza AT gmail DOT com> 11-03-21
 */
@Data
@NoArgsConstructor
public class IndeconLastValuesResponseDto {

    private IndeconValueDto cobre;
    private IndeconValueDto dolar;
    private IndeconValueDto euro;
    private IndeconValueDto ipc;
    private IndeconValueDto ivp;
    private IndeconValueDto oro;
    private IndeconValueDto plata;
    private IndeconValueDto uf;
    private IndeconValueDto utm;
    private IndeconValueDto yen;

}
