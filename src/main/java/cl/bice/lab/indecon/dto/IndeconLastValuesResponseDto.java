package cl.bice.lab.indecon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Cristian Beroiza <cberoiza AT gmail DOT com> 13-03-21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IndeconLastValuesResponseDto {
    private List<IndeconValueDto> indeconValueDtoList;
}
