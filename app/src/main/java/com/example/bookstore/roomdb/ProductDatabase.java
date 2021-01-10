package com.example.bookstore.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bookstore.interfaces.ProductDAO;
import com.example.bookstore.model.Products;

@Database(entities = {Products.class}, version = 2, exportSchema = false)
public abstract class ProductDatabase extends RoomDatabase {

    public abstract ProductDAO getProductDAO();

    private static ProductDatabase productDatabase;

    public static synchronized ProductDatabase getInstance(Context context) {
        if (productDatabase == null) {
            productDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    ProductDatabase.class, "product_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return productDatabase;
    }

    public void cleanUp() {
        productDatabase = null;
    }
}
