package com.example.bookstore.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bookstore.R;
import com.example.bookstore.adapters.ProductRecylerViewAdapter;
import com.example.bookstore.databinding.ActivityLoadBinding;
import com.example.bookstore.viewmodel.ProductSyncViewModel;

public class LoadActivity extends AppCompatActivity {

    ActivityLoadBinding mBinding;
    ProductSyncViewModel mViewModel;
    ProductRecylerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_load);
        mBinding.setActivity(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getResources().getString(R.string.product_list));
        }
        mViewModel = ViewModelProviders.of(this).get(ProductSyncViewModel.class);
        mViewModel.getProductResponseLiveData().observe(this, productUpadteResponse -> {
            mBinding.bookRecycler.setLayoutManager(new LinearLayoutManager(this));
            mAdapter = new ProductRecylerViewAdapter(productUpadteResponse, getBaseContext());
            mAdapter.notifyDataSetChanged();
            mBinding.bookRecycler.setAdapter(mAdapter);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(LoadActivity.this, MainActivity.class));
        finishAffinity();
        overridePendingTransition(0, 0);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}