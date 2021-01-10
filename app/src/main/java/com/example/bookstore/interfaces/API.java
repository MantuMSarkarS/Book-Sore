package com.example.bookstore.interfaces;

import com.example.bookstore.model.Product;
import com.example.bookstore.model.ProductAddResponse;
import com.example.bookstore.model.ProductUpadteResponse;
import com.example.bookstore.model.Products;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {

    @GET("api/getAllAvailableBooks")
    Call<ProductUpadteResponse> getAllProduct();


    @POST("api/addNewProduct")
    Call<ProductAddResponse> addProduct(
            @Body Products products);
}
