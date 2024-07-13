package org.example.colorado.mapper;

import org.example.colorado.dto.ProductsDto;
import org.example.colorado.entity.Products;

public class ProductMapper {

    public static ProductsDto toDto(Products product) {
        if (product == null) {
            return null;
        }

        ProductsDto dto = new ProductsDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setType(product.getType());
        dto.setPlace(product.getPlace());
        dto.setQuantity(product.getQuantity());
        dto.setPrice(product.getPrice());
        dto.setCreatedAt(product.getCreatedAt());
        dto.setUpdatedAt(product.getUpdatedAt());
        dto.setImageUrl(product.getImageUrl());

        return dto;
    }

    public static Products toEntity(ProductsDto dto, String imageUrl) {
        if (dto == null) {
            return null;
        }

        Products product = new Products();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setType(dto.getType());
        product.setPlace(dto.getPlace());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());
        product.setCreatedAt(dto.getCreatedAt());
        product.setUpdatedAt(dto.getUpdatedAt());
        product.setImageUrl(imageUrl);

        return product;
    }
}
