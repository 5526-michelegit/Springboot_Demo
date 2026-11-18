package com.demo.springboot_demo.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



// @Data genera getter, setter, equals, hashCode e toString.    
// @NoArgsConstructor e @AllArgsConstructor generano i due costruttori.

@Data 
@NoArgsConstructor 
@AllArgsConstructor 


public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
}
