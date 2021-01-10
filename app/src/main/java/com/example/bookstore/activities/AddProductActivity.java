package com.example.bookstore.activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookstore.R;
import com.example.bookstore.databinding.ActivityAddProductBinding;
import com.example.bookstore.model.Products;
import com.example.bookstore.viewmodel.ProductViewModel;

import java.util.Objects;

public class AddProductActivity extends AppCompatActivity {

    ActivityAddProductBinding mBinding;
    ProductViewModel mViewModel;
    private ProgressDialog mBar;
    public int mMobile;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_product);
        mBinding.setActivity(this);
        mViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getResources().getString(R.string.add_a_product));
        }
        mBinding.productName1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    mBinding.productName.setError(null);
                }
            }
        });
        mBinding.productDescription1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    mBinding.productDescription.setError(null);
                }
            }
        });
        mBinding.productQuantity1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    mBinding.productQuantity.setError(null);
                }
            }
        });
        mBinding.productPrice1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    mBinding.productPrice.setError(null);
                }
            }
        });
        mBinding.saveProduct.setOnClickListener(v -> {
            if (isValid()) {
                mBar = new ProgressDialog(AddProductActivity.this);
                mBar.setCancelable(false);
                mBar.setMessage("Saving Please Wait");
                mBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                mBar.show();
                try {
                    Products products = new Products(Objects.requireNonNull(mBinding.productName.getEditText()).getText().toString(),
                            Objects.requireNonNull(mBinding.productDescription.getEditText()).getText().toString(),
                            Integer.parseInt(Objects.requireNonNull(mBinding.productQuantity.getEditText()).getText().toString()),
                            Integer.parseInt(Objects.requireNonNull(mBinding.productPrice.getEditText()).getText().toString()),
                            Objects.requireNonNull(mBinding.mobileNo.getText()).toString());
                    mViewModel.insertFMDetails(products);
                    Toast.makeText(this, "Product details saved Successfully", Toast.LENGTH_SHORT).show();
                    mBinding.productPrice1.setText(null);
                    mBinding.productName1.setText(null);
                    mBinding.productDescription1.setText(null);
                    mBinding.productQuantity1.setText(null);
                    mBar.dismiss();
                } catch (NumberFormatException exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    public boolean isValid() {
        if (mBinding.productName.getEditText().getText().toString().equals("")) {
            mBinding.productName.setError("Please enter product name");
            return false;
        } else if (mBinding.productDescription.getEditText().getText().toString().equals("")) {
            mBinding.productDescription.setError("Please enter product description");
            return false;
        } else if (mBinding.productQuantity.getEditText().getText().toString().equals("")) {
            mBinding.productQuantity.setError("Please enter product quantity");
            return false;
        } else if (mBinding.productPrice.getEditText().getText().toString().equals("")) {
            mBinding.productPrice.setError("Please enter product price");
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(AddProductActivity.this, AddProductAndLoadActivity.class));
        finishAffinity();
        overridePendingTransition(0, 0);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}