package com.services.sicol.app.dto;

import com.services.sicol.app.model.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {
    private Integer supplierID;
    private String name;
    private String ruc;
    private String contactName;
    private String phone;
    private String email;
    private String address;
    private GeneralTypeDTO status;
    private Date createdAt;
    private Date updatedAt;

    // method to convert from entity to DTO
    public static SupplierDTO formEntity(Supplier supplier) {
        if (supplier == null) return null;
        return SupplierDTO.builder()
                .supplierID(supplier.getSupplierID())
                .name(supplier.getName())
                .ruc(supplier.getRuc())
                .contactName(supplier.getContactName())
                .phone(supplier.getPhone())
                .email(supplier.getEmail())
                .address(supplier.getAddress())
                .status(GeneralTypeDTO.formEntity(supplier.getStatus()))
                .createdAt(Date.from(supplier.getCreatedAt().toInstant()))
                .updatedAt(Date.from(supplier.getUpdatedAt().toInstant()))
                .build();
    }

    // method to convert a list of entities into a list of DTOs
    public static List<SupplierDTO> fromEntities(List<Supplier> suppliers) {
        if (suppliers == null || suppliers.isEmpty()) return List.of();
        return suppliers.stream()
                .map(SupplierDTO::formEntity)
                .collect(Collectors.toList());
    }

    // method to convert from DTO to entity
    public Supplier toEntity() {
        return Supplier.builder()
                .name(this.name)
                .ruc(this.ruc)
                .contactName(this.contactName)
                .phone(this.phone)
                .email(this.email)
                .address(this.address)
                .status(this.status != null ? this.status.toEntity() : null)
                .build();
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + supplierID +
                "name=" + name +
                "ruc=" + ruc +
                "address=" + address +
                "}";
    }
}
