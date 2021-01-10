package com.example.bookstore.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bookstore.interfaces.API;
import com.example.bookstore.model.Product;
import com.example.bookstore.model.ProductAddResponse;
import com.example.bookstore.model.ProductUpadteResponse;
import com.example.bookstore.model.Products;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductSyncRepository {
    private static API api;
    private static final String BASE_URL = "http://15.206.209.151/";
    private MutableLiveData<ProductUpadteResponse> productList;

    public ProductSyncRepository(Application application) {
        productList = new MutableLiveData<>();
        api = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(API.class);
    }


    public LiveData<ProductUpadteResponse> getProductLiveData(){
        api.getAllProduct().enqueue(new Callback<ProductUpadteResponse>() {
            @Override
            public void onResponse(Call<ProductUpadteResponse> call, Response<ProductUpadteResponse> response) {
                if (response.isSuccessful())
                productList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ProductUpadteResponse> call, Throwable t) {
                productList.setValue(null);
            }
        });
        return productList;
    }
    public void addProduct(Products products){
        api.addProduct(products).enqueue(new Callback<ProductAddResponse>() {
            @Override
            public void onResponse(Call<ProductAddResponse> call, Response<ProductAddResponse> response) {
                if (response.isSuccessful())
                Log.d("TAG", "onResponse: "+response.body().getResults().getMessage());
            }

            @Override
            public void onFailure(Call<ProductAddResponse> call, Throwable t) {

            }
        });
    }
}
