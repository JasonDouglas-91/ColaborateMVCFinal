package com.combinationMVC.boot.exploreComputer.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PRODUCT")
public class Product implements Serializable {
    @Id
    @Column(name="PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="PRODUCT_NAME")
    private String name;
    @Column(name="PRODUCT_TYPE")
    private String type;
    @Column(name="PRODUCT_PRICE")
    private long price;
    @Column(name="PRODUCT_DESCRIPTION")
    private String description;

    public Product(){}

    public Product(long id, String name, String type, long price, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
