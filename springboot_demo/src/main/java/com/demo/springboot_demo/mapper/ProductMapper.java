package com.demo.springboot_demo.mapper;

import org.springframework.stereotype.Component;

import com.demo.springboot_demo.dto.ProductRequest;
import com.demo.springboot_demo.dto.ProductResponse;
import com.demo.springboot_demo.model.Product;

@Component 
public class ProductMapper {

    public Product toEntity(ProductRequest productRequest) {
        return new Product(productRequest.getName(), productRequest.getDescription(), productRequest.getPrice());        //product.setName(productRequest.getName()); // se ci fossero i setter andrebbe bene cosi
        //product.setDescription(productRequest.getDescription());
        //product.setPrice(productRequest.getPrice());
    }


    public ProductResponse toResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }
}
