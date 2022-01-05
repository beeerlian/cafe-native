package com.example.utsprakpam;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Food {
    public String name;
    public String deskripsi;
    public String price;
    public Drawable imagePath;
    public int imageUri;

    public Food(String name, String deskripsi, Drawable path, String price, int imageUri){
        this.name = name;
        this.deskripsi = deskripsi;
        this.price = price;
        this.imagePath = path;
        this.imageUri = imageUri;
    }

}
