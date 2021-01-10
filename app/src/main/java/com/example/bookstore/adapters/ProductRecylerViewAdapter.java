package com.example.bookstore.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.R;
import com.example.bookstore.model.Product;
import com.example.bookstore.model.ProductUpadteResponse;
import com.squareup.picasso.Picasso;

public class ProductRecylerViewAdapter extends RecyclerView.Adapter<ProductRecylerViewAdapter.MyViewHolder>{

    ProductUpadteResponse productUpadteResponse;
    Context mContext;
    public ProductRecylerViewAdapter(ProductUpadteResponse productUpadteResponse, Context mContext) {
        this.productUpadteResponse=productUpadteResponse;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.product_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product product=productUpadteResponse.getProducts().get(position);
        holder.mName.setText(product.mBookName);
        holder.mDesc.setText(product.mBookDesc);
        holder.mAuthor.setText(product.mBookAuthor);
        holder.mPrice.setText(String.valueOf(product.mBookPrice));
        Picasso.with(mContext).load(product.mImageUrl).into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return productUpadteResponse.getProducts().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mName,mDesc,mAuthor,mPrice;
        ImageView mImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mName=itemView.findViewById(R.id.book_name);
            mDesc=itemView.findViewById(R.id.book_desc);
            mAuthor=itemView.findViewById(R.id.author_name);
            mPrice=itemView.findViewById(R.id.book_price);
            mImage=itemView.findViewById(R.id.book_image);
        }
    }
}
