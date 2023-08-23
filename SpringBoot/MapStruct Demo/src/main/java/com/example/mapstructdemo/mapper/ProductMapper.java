package com.example.mapstructdemo.mapper;

import com.example.mapstructdemo.dto.ProductDto;
import com.example.mapstructdemo.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring",imports = UUID.class)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "product.descr",target="description",defaultValue = "Describing")
    ProductDto modelToDto(Product product);

    List<ProductDto> modelsToDtos(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "itemId",expression = "java(UUID.randomUUID().toString())")
    Product dtoToModel(ProductDto productDto);
}
