package com.example.mapstructdemo.controller;

import com.example.mapstructdemo.dto.ProductDto;
import com.example.mapstructdemo.mapper.ProductMapper;
import com.example.mapstructdemo.model.Product;
import com.example.mapstructdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<Product> save(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productRepository.save(
                productMapper.dtoToModel(productDto)), HttpStatus.CREATED);
    }


    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> findAll(){
        return new ResponseEntity<>(productMapper.modelsToDtos(productRepository.findAll()),HttpStatus.OK);

    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable int id){
        return new ResponseEntity<>(productMapper.modelToDto(productRepository.findById(id).get()),HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        ProductDto productDto = productMapper.modelToDto(productRepository.findById(id).get());
        productRepository.deleteById(productDto.getId());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

