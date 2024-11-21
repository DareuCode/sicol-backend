package com.services.sicol.app.controller;

import com.services.sicol.app.dto.GeneralTypeDTO;
import com.services.sicol.app.service.GeneralTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/settings-data")
public class GeneralTypeController {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private GeneralTypeService generalTypeService;

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
