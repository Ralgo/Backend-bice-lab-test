package cl.bice.lab.indecon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Cristian Beroiza <cberoiza AT gmail DOT com> 11-03-21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IndeconLastValuesDto {

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
