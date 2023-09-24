package com.example.demo.Product;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String name;
    private String description;
    private boolean onSale;
    private BigDecimal price;
    private int stockQuantity;

    // constructor with all properties is omitted

    public Product(Long id, String name, String description, boolean onSale, BigDecimal price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.onSale = onSale;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // getters and setters are omitted

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
