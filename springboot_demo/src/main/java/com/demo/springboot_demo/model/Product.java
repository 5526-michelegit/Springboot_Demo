package com.demo.springboot_demo.model;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;



@Entity 
@Table (name = "products")
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 100)
    private String name;

    @Column (length = 500)
    private String description;

    @Column (nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column (name = "createdAt", nullable = false, updatable = false)
    private Instant createdAt;



    protected Product() {
        // questo è un costruttore vuoto protetto richiesto da JPA
    }



    //costruttore pubblico per creare un nuovo prodotto
    public Product(String name, String description, BigDecimal price){
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = Instant.now();
    }



    // callback del ciclo di vita JPA per impostare la data di creazione prima di salvare l'entità nel database
    @PrePersist 
    void prePersistonCreate() {
        this.createdAt = Instant.now();
    }


    
    // getter per gli attributi del prodotto
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }




    //setter che non voglio utilizzare
    //public void setName(String name) {
        //this.name = name;
    //}

    // al posto dei setter utilizzo questo metodo di update per aggiornare il prodotto
    public void update(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }





    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
