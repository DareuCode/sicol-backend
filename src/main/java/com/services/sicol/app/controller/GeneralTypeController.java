package com.services.sicol.app.controller;

import com.services.sicol.app.dto.GeneralTypeDTO;
import com.services.sicol.app.service.GeneralTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/settings-data")
public class GeneralTypeController {
    private static final Logger logger= LoggerFactory.getLogger(GeneralTypeController.class);
    private final GeneralTypeService generalTypeService;

    public GeneralTypeController(GeneralTypeService generalTypeService) {
        this.generalTypeService = generalTypeService;
    }

    @GetMapping()
    public List<GeneralTypeDTO> getAllGeneralTypes() {
        return generalTypeService.getAllGeneralTypes();
    }

    @GetMapping("/{type}")
    public List<GeneralTypeDTO> getGeneralTypesByType(@PathVariable Integer type) {
        return generalTypeService.getGeneralTypesByType(type);
    }

    @PostMapping()
    public GeneralTypeDTO creatNewGeneralType(@RequestBody GeneralTypeDTO generalTypeDTO) {
        logger.info("DTO");
        logger.info(generalTypeDTO.toString());
        return generalTypeService.createNewGeneralType(generalTypeDTO);
    }
}
