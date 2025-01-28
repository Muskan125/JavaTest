package com.test.testui;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.test.testui.Models.ClothModel;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<ClothModel> productList;

    public ProductAdapter(Context context, List<ClothModel> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_layout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ClothModel product = productList.get(position);

        holder.productName.setText(product.getProductName());
        holder.brandName.setText(product.getBrandName());
        holder.price.setText(product.getPrice());

        String imagePath = product.getImageUrl();
        Log.d("imagePath", "imagePath::::"+imagePath);
        Glide.with(context)
                .load(Uri.parse("file:///android_asset/" + imagePath))
                .into(holder.imageView);
//        Glide.with(context).asBitmap().load(Uri.parse("file:///android_asset/" + imagePath)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productName, brandName, price;
        ImageView imageView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.textProductName);
            brandName = itemView.findViewById(R.id.textBrandName);
            price = itemView.findViewById(R.id.textPrice);
            imageView = itemView.findViewById(R.id.imageProduct);
        }
    }
}

