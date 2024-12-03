package com.services.sicol.app.service;

import com.services.sicol.app.dto.GeneralTypeDTO;
import com.services.sicol.app.model.GeneralType;
import com.services.sicol.app.repository.GeneralTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GeneralTypeService {
    private static final Logger logger= LoggerFactory.getLogger(GeneralTypeService.class);

    private final GeneralTypeRepository generalTypeRepository;

    public GeneralTypeService(GeneralTypeRepository generalTypeRepository) {
        this.generalTypeRepository = generalTypeRepository;
    }

    public List<GeneralTypeDTO>  getAllGeneralTypes() {
        try {
            return GeneralTypeDTO.fromEntities(generalTypeRepository.findAll());
        } catch(Exception e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<GeneralTypeDTO> getGeneralTypesByType(Integer type) {
        return GeneralTypeDTO.fromEntities(generalTypeRepository.findByType(type));
    }

    public GeneralTypeDTO createNewGeneralType(GeneralTypeDTO generalTypeDTO) {
        GeneralType generalType = GeneralType.builder()
                .type(generalTypeDTO.getType())
                .category(generalTypeDTO.getCategory())
                .subclass(generalTypeDTO.getSubclass())
                .build();
        logger.info(generalType.toString());
        GeneralType response = generalTypeRepository.save(generalType);
        return GeneralTypeDTO.formEntity(response);
    }

    public GeneralTypeDTO updateGeneralType(GeneralTypeDTO generalTypeDTO) {
        return new GeneralTypeDTO();
    }
}
