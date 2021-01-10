package com.example.bookstore.model;

import com.google.gson.annotations.SerializedName;

public class ProductAddResponse {
    @SerializedName("results")
    Results results;

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}
