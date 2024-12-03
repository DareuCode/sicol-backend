package com.services.sicol.app.controller;

import com.services.sicol.app.dto.GeneralTypeDTO;
import com.services.sicol.app.service.GeneralTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

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
        logger.info("Creating new general type");
        return generalTypeService.createNewGeneralType(generalTypeDTO);
    }

    @PutMapping()
    public GeneralTypeDTO updateGeneralType(@RequestBody GeneralTypeDTO generalTypeDTO) {
        logger.info("Update de general type");
        return generalTypeService.createNewGeneralType(generalTypeDTO);
    }
}
