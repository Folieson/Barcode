package com.example.barcode.data;

public class Product {
    private String id;
    private String name;
    private String brand;
    private String category;
    private String country;
    Product(String id, String name, String brand, String category, String country) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getBrand() { return brand; }

    public String getId() {
        return id;
    }

    public String getCategory() { return category; }

    public String getCountry() { return country; }
}
