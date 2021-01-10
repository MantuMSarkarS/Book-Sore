package com.example.bookstore.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "books")
public class Products implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Integer sid;
    @SerializedName("product_name")
    public String mProductName;
    @SerializedName("product_desc")
    public String mProductDesc;
    @SerializedName("product_quantity")
    public   int product_quantity;
    @SerializedName("product_price")
    public int mProductPrice;
    @SerializedName("user_mobile_no")
    public String mMobileNumber;
    @Ignore
    public Products() {
    }

    public Products(String mProductName, String mProductDesc, int product_quantity, int mProductPrice, String mMobileNumber) {
        this.mProductName = mProductName;
        this.mProductDesc = mProductDesc;
        this.product_quantity = product_quantity;
        this.mProductPrice = mProductPrice;
        this.mMobileNumber = mMobileNumber;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getmProductName() {
        return mProductName;
    }

    public void setmProductName(String mProductName) {
        this.mProductName = mProductName;
    }

    public String getmProductDesc() {
        return mProductDesc;
    }

    public void setmProductDesc(String mProductDesc) {
        this.mProductDesc = mProductDesc;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public int getmProductPrice() {
        return mProductPrice;
    }

    public void setmProductPrice(int mProductPrice) {
        this.mProductPrice = mProductPrice;
    }

    public String getmMobileNumber() {
        return mMobileNumber;
    }

    public void setmMobileNumber(String mMobileNumber) {
        this.mMobileNumber = mMobileNumber;
    }
}
