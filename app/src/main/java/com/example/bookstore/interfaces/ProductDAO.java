package com.example.bookstore.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bookstore.model.Product;
import com.example.bookstore.model.Products;

import java.util.List;

@Dao
public interface ProductDAO {
    @Insert
    void productInsert(Products products);
    @Query("Select * from books")
    LiveData<List<Products>> getAllStoredProduct();
}
