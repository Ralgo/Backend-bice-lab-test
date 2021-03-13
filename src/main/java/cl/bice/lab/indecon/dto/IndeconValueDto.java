/*
 * Copyright 2021 Falabella Tecnologia Ltda. - Todos los derechos reservados.
 */
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
public class IndeconValueDto {

    private String key;
    private String name;
    private String unit;
    private String date;
    private double value;

}
