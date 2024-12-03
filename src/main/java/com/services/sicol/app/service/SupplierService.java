package com.services.sicol.app.service;

import com.services.sicol.app.dto.SupplierDTO;
import com.services.sicol.app.model.GeneralType;
import com.services.sicol.app.model.Supplier;
import com.services.sicol.app.repository.GeneralTypeRepository;
import com.services.sicol.app.repository.SupplierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private static final Logger logger= LoggerFactory.getLogger(SupplierService.class);

    private final SupplierRepository supplierRepository;
    private final GeneralTypeRepository generalTypeRepository;

    public SupplierService(SupplierRepository supplierRepository, GeneralTypeRepository generalTypeRepository) {
        this.supplierRepository = supplierRepository;
        this.generalTypeRepository = generalTypeRepository;
    }

    public List<SupplierDTO> findAll() {
        try {
            return SupplierDTO.fromEntities(supplierRepository.findAll());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    public SupplierDTO findById(Integer id) {
        try {
            Optional<Supplier> supplier = supplierRepository.findById(id);
            if (supplier.isEmpty()) throw new Exception("Supplier not found");
            return SupplierDTO.formEntity(supplier.get());
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public SupplierDTO save(SupplierDTO supplierDTO) {
        try {
            // active state (3) by default
            GeneralType status = generalTypeRepository.findBySubtype(3);
            Supplier supplier = supplierDTO.toEntity();
            supplier.setStatus(status);
            return SupplierDTO.formEntity(supplierRepository.save(supplier));
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
