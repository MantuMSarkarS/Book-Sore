package com.example.bookstore.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.bookstore.interfaces.ProductDAO;
import com.example.bookstore.roomdb.ProductDatabase;
import com.example.bookstore.model.Products;

import java.util.List;

public class ProductRepository {
    private ProductDAO productDAO;

    ProductDatabase productDatabase;

    public ProductRepository(Application application) {
        productDatabase = ProductDatabase.getInstance(application);
        productDAO = productDatabase.getProductDAO();
    }

    public void insertProductTable(Products products) {
        new InsertProductAsynctask(productDAO).execute(products);
    }

    public static class InsertProductAsynctask extends AsyncTask<Products, Void, Void> {

        private ProductDAO productDAO;

        private InsertProductAsynctask(ProductDAO productDAO) {
            this.productDAO = productDAO;
        }

        @Override
        protected Void doInBackground(Products... fmEntries) {
            productDAO.productInsert(fmEntries[0]);
            return null;
        }
    }
    public LiveData<List<Products>> getAllBooks(){
        new FetchProductAsynTask(productDAO).execute();
        return null;
    }
    public class FetchProductAsynTask extends AsyncTask<Products,Void,Void>{
        private ProductDAO productDAO;

        private FetchProductAsynTask(ProductDAO productDAO) {
            this.productDAO = productDAO;
        }

        @Override
        protected Void doInBackground(Products... voids) {
            getAllStoredProduct();
            return null;
        }
    }
    public void getAllStoredProduct(){
        productDAO.getAllStoredProduct();
    }
}
