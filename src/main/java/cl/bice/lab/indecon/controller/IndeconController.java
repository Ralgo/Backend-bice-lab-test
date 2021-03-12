package cl.bice.lab.indecon.controller;

import cl.bice.lab.indecon.dto.IndeconLastValuesResponseDto;
import cl.bice.lab.indecon.service.IndeconService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cristian Beroiza <cberoiza AT gmail DOT com> 11-03-21
 */
@RestController
@RequestMapping("/indecon")
public class IndeconController {

    private final IndeconService indeconService;

    @Autowired
    public IndeconController(IndeconService indeconService) {
        this.indeconService = indeconService;
    }

    @GetMapping("/")
    @ApiOperation("Service that return all the last values from the indecon site api")
    public IndeconLastValuesResponseDto getLastValues() {
        return indeconService.getLastValues();
    }


}
