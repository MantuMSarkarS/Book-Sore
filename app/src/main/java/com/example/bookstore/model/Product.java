package com.example.bookstore.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable {

    @SerializedName("book_id")
    private Integer mBookdId;
    @SerializedName("book_name")
    public String mBookName;
    @SerializedName("book_desc")
    public String mBookDesc;
    @SerializedName("book_author")
    public String mBookAuthor;
    @SerializedName("book_price")
    public int mBookPrice;
    @SerializedName("book_img_url")
    public String mImageUrl;
    @Ignore
    public Product() {
    }

    public Product(Integer mBookdId, String mBookName, String mBookDesc, String mBookAuthor, int mBookPrice, String mImageUrl) {
        this.mBookdId = mBookdId;
        this.mBookName = mBookName;
        this.mBookDesc = mBookDesc;
        this.mBookAuthor = mBookAuthor;
        this.mBookPrice = mBookPrice;
        this.mImageUrl = mImageUrl;
    }

    public Integer getmBookdId() {
        return mBookdId;
    }

    public void setmBookdId(Integer mBookdId) {
        this.mBookdId = mBookdId;
    }

    public String getmBookName() {
        return mBookName;
    }

    public void setmBookName(String mBookName) {
        this.mBookName = mBookName;
    }

    public String getmBookDesc() {
        return mBookDesc;
    }

    public void setmBookDesc(String mBookDesc) {
        this.mBookDesc = mBookDesc;
    }

    public String getmBookAuthor() {
        return mBookAuthor;
    }

    public void setmBookAuthor(String mBookAuthor) {
        this.mBookAuthor = mBookAuthor;
    }

    public int getmBookPrice() {
        return mBookPrice;
    }

    public void setmBookPrice(int mBookPrice) {
        this.mBookPrice = mBookPrice;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
