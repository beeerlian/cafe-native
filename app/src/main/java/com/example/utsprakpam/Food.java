package com.example.utsprakpam;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Food {
    String name;
    String deskripsi;
    String price;
    Drawable imagePath;

    Food(String name, String deskripsi, Drawable path, String price){
        this.name = name;
        this.deskripsi = deskripsi;
        this.price = price;
        this.imagePath = path;
    }

}
