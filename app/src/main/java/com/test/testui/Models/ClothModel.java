package com.test.testui.Models;

public class ClothModel {
    private String productName;
    private String brandName;
    private String price;
//    private int imageResId;
    private String imageUrl;

    public ClothModel(String productName, String brandName, String price, String imageUrl
    ) {
        this.productName = productName;
        this.brandName = brandName;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getPrice() {
        return price;
    }
//Might User other time
//    public int getImageResId() {
//        return imageResId;
//    }
    
    public String getImageUrl() {
        return imageUrl;
    }
}
