package cl.bice.lab.test.dto;

import lombok.Data;

/**
 * @author Cristian Beroiza <cberoiza AT gmail DOT cl> 11-03-21
 */
@Data
public class IndeconLastResponseDto {

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
