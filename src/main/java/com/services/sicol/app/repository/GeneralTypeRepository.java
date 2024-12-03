package com.services.sicol.app.repository;

import com.services.sicol.app.model.GeneralType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneralTypeRepository extends JpaRepository<GeneralType, Integer> {

    List<GeneralType> findByType(Integer type);
    GeneralType findBySubtype(Integer subtype);
}
