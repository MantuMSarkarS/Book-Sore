package com.example.bookstore.model;

import com.example.bookstore.model.Product;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ProductUpadteResponse implements Serializable {
    @SerializedName("results")
    List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
