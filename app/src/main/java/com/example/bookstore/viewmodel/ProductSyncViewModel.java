package com.example.bookstore.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.bookstore.model.ProductUpadteResponse;
import com.example.bookstore.model.Products;
import com.example.bookstore.repository.ProductSyncRepository;

public class ProductSyncViewModel extends AndroidViewModel {
    private ProductSyncRepository productSyncRepository;
    private LiveData<ProductUpadteResponse> productList;


    public ProductSyncViewModel(@NonNull Application application) {
        super(application);
        productSyncRepository = new ProductSyncRepository(application);
        productList = productSyncRepository.getProductLiveData();
    }

    public LiveData<ProductUpadteResponse> getProductResponseLiveData() {
        return productList;
    }

    public void addProduct(Products products) {
        productSyncRepository.addProduct(products);
    }

}
