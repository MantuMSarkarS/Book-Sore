package com.example.bookstore.model;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("success")
    private Integer success;
    @SerializedName("message")
    private String message;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
