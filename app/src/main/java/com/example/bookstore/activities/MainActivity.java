package com.example.bookstore.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.bookstore.R;
import com.example.bookstore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setActivity(this);
        mBinding.addProduct.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddProductAndLoadActivity.class));
            finishAffinity();
            overridePendingTransition(0, 0);
        });
        mBinding.loadBook.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LoadActivity.class));
            finishAffinity();
            overridePendingTransition(0, 0);
        });
    }
}