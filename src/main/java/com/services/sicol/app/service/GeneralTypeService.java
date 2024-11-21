package com.services.sicol.app.service;

import com.services.sicol.app.dto.GeneralTypeDTO;
import com.services.sicol.app.model.GeneralType;
import com.services.sicol.app.repository.GeneralTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralTypeService {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GeneralTypeRepository generalTypeRepository;

    public List<GeneralTypeDTO>  getAllGeneralTypes() {
        try {
            return GeneralTypeDTO.fromEntities(generalTypeRepository.findAll());
        } catch(Exception e) {
            logger.error("Error: ", e);
            return (List<GeneralTypeDTO>) new GeneralTypeDTO();
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
}
