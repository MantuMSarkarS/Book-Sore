package com.example.bookstore.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookstore.R;
import com.example.bookstore.databinding.ActivityAddProductAndLoadBinding;
import com.example.bookstore.viewmodel.ProductSyncViewModel;
import com.example.bookstore.viewmodel.ProductViewModel;

public class AddProductAndLoadActivity extends AppCompatActivity {

    ActivityAddProductAndLoadBinding mBinding;
    ProductSyncViewModel mViewModel;
    ProductViewModel mProductViewModel;
    ProgressDialog mBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_product_and_load);
        mBinding.setActivity(this);
        mViewModel = ViewModelProviders.of(this).get(ProductSyncViewModel.class);
        mProductViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getResources().getString(R.string.addandload_title));
        }
        mBinding.addProduct.setOnClickListener(v -> {
            startActivity(new Intent(AddProductAndLoadActivity.this, AddProductActivity.class));
            finishAffinity();
            overridePendingTransition(0, 0);
        });
        mBinding.syncBook.setOnClickListener(v -> {
            mBar = new ProgressDialog(AddProductAndLoadActivity.this);
            mBar.setCancelable(false);
            mBar.setMessage("Uploading Please Wait");
            mBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mBar.show();
            mProductViewModel.getProducts().observe(this, products -> {
                for (int i = 0; i < products.size(); i++) {
                    mBar.dismiss();
                    mViewModel.addProduct(products.get(i));
                    Toast.makeText(this, "Product added successfully", Toast.LENGTH_SHORT).show();
                }

            });

        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(AddProductAndLoadActivity.this, MainActivity.class));
        finishAffinity();
        overridePendingTransition(0, 0);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}