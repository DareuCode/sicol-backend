package com.services.sicol.app.dto;

import com.services.sicol.app.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private GeneralTypeDTO category;
    private GeneralTypeDTO status;
    private Date createdAt;
    private Date updatedAt;

    // method to convert from entity to DTO
    public static ProductDTO fromEntity(Product product) {
        if (product == null) return null;
        return ProductDTO.builder()
                .productId(product.getProductID())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .imageUrl(product.getImagesUrl())
                .category(GeneralTypeDTO.formEntity(product.getCategory()))
                .status(GeneralTypeDTO.formEntity(product.getStatus()))
                .build();
    }

    // method to convert a list of entities into a list of DTOs
    public static List<ProductDTO> fromEntities(List<Product> products) {
        if (products == null || products.isEmpty()) return List.of();
        return products.stream()
                .map(ProductDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                "name=" + name +
                "description=" + description +
                "price=" + price +
                "}";
    }
}
