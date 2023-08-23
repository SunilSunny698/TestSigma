package com.example.mapstructdemo.mapper;

import com.example.mapstructdemo.dto.ProductDto;
import com.example.mapstructdemo.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-08T15:20:30+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto modelToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        if ( product.getDescr() != null ) {
            productDto.setDescription( product.getDescr() );
        }
        else {
            productDto.setDescription( "Describing" );
        }
        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setQuantity( String.valueOf( product.getQuantity() ) );
        productDto.setPrice( product.getPrice() );
        productDto.setItemId( product.getItemId() );

        return productDto;
    }

    @Override
    public List<ProductDto> modelsToDtos(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( modelToDto( product ) );
        }

        return list;
    }

    @Override
    public Product dtoToModel(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setDescr( productDto.getDescription() );
        product.setId( productDto.getId() );
        product.setName( productDto.getName() );
        if ( productDto.getQuantity() != null ) {
            product.setQuantity( Integer.parseInt( productDto.getQuantity() ) );
        }
        product.setPrice( productDto.getPrice() );

        product.setItemId( UUID.randomUUID().toString() );

        return product;
    }
}
