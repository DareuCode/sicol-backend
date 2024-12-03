package com.services.sicol.app.dto;

import com.services.sicol.app.model.GeneralType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneralTypeDTO {
    private Integer subtype;
    private String subclass;
    private Integer type;
    private String category;
    private boolean deleted;
    private Date createdAt;
    private Date updatedAt;

    // method to convert from entity to DTO
    public static GeneralTypeDTO formEntity(GeneralType generalType) {
        return GeneralTypeDTO.builder()
                .subtype(generalType.getSubtype())
                .subclass(generalType.getSubclass())
                .type(generalType.getType())
                .category(generalType.getCategory())
                .deleted(generalType.isDeleted())
                .createdAt(Date.from(generalType.getCreatedAt().toInstant()))
                .createdAt(Date.from(generalType.getUpdatedAt().toInstant()))
                .build();
    }

    // method to convert a list of entities into a list of DTOs
    public static List<GeneralTypeDTO> fromEntities(List<GeneralType> generalTypes) {
        return generalTypes.stream()
                .map(GeneralTypeDTO::formEntity)
                .collect(Collectors.toList());
    }

    // method to convert from DTO to entity
    public GeneralType toEntity() {
        return GeneralType.builder()
                .subclass(this.subclass)
                .subtype(this.subtype)
                .type(this.type)
                .category(this.category)
                .build();
    }

    @Override
    public String toString() {
        return "GeneralType{" +
                "subtype=" + subtype +
                ", subclass='" + subclass + '\'' +
                ", type=" + type +
                ", category='" + category + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
