/*
 * Copyright 2021 Falabella Tecnologia Ltda. - Todos los derechos reservados.
 */
package cl.bice.lab.test.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * @author Cristian Beroiza <crberoizar AT falabella DOT cl> 11-03-21
 */

@Data
@Builder
public class IndeconValueDto {

  private String key;
  private String name;
  private String unit;
  private LocalDateTime date;
  private double value;

}
