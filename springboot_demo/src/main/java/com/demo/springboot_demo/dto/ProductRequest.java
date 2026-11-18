package com.demo.springboot_demo.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// nella maggior parte dei progetti si utilizza Lombok
// @Data genera getter, setter, equals, hashCode e toString. 
// @NoArgsConstructor e @AllArgsConstructor generano i due costruttori.

@Data
@NoArgsConstructor 
@AllArgsConstructor

public class ProductRequest {

    @NotBlank(message = "il nome è obbligatorio")
    @Size(max = 100, message = "il nome può avere al massimo 100 caratteri")    
    private String name;

    @Size(max = 500, message = "la descrizione può avere al massimo 500 caratteri")
    private String description;

    @NotNull(message = "il prezzo è obbligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "il prezzo deve essere maggiore di zero")
    @Digits(integer = 8, fraction = 2, message = "formato prezzo non valido (max 8 interi e 2 decimali)")
    private BigDecimal price;


}
