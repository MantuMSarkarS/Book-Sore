package com.example.bookstore.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bookstore.interfaces.ProductDAO;
import com.example.bookstore.roomdb.ProductDatabase;
import com.example.bookstore.model.Products;
import com.example.bookstore.repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepository productRepository;
    private ProductDAO productDAO;

    public LiveData<List<Products>> productsList;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        productRepository=new ProductRepository(application);
        ProductDatabase productDatabase = ProductDatabase.getInstance(application);
        productDAO = productDatabase.getProductDAO();
    }

    public void insertFMDetails(Products products){
        productRepository.insertProductTable(products);
    }
    public LiveData<List<Products>> getProducts(){
        //return productDAO.getAllStoredProduct();
        return productRepository.getAllBooks();
    }
}
