//https://youtu.be/YxZ7Dm2HD-A?si=CpRr3VEeAB3wgAFb - Recycler All Explained
package com.test.testui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.testui.Models.ClothModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Page4 extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ClothModel> productList;
    ProductAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4_activity);

        recyclerView = findViewById(R.id.recycle_linear);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = loadProductsFromJSON();
        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }

    private List<ClothModel> loadProductsFromJSON() {
        List<ClothModel> products = new ArrayList<>();
        try {
            InputStream is = getAssets().open("dummy.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");

            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String productName = jsonObject.getString("productName");
                String brandName = jsonObject.getString("brandName");
                String price = jsonObject.getString("price");
                String image = jsonObject.getString("image");

                products.add(new ClothModel(productName, brandName, price, image));
            }
        } catch (IOException | JSONException e) {
            Log.e("JSON_ERROR", "Error loading JSON", e);
        }
        return products;
    }
}

