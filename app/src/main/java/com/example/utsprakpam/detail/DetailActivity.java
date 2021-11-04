package com.example.utsprakpam.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.utsprakpam.DataSource;
import com.example.utsprakpam.Food;
import com.example.utsprakpam.R;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    TextView judultextView;
    TextView hargaTextView;
    TextView descTextView;
    ImageView imageView;
    List<Food> foods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        foods = DataSource.getAllFood(getApplicationContext());

        setDataFoodIntoLayout(getIntent().getIntExtra("index", -1));

    }
    void setDataFoodIntoLayout(int index){
        if(index < 0){
            hargaTextView = findViewById(R.id.harga_tv);
            hargaTextView.setText("Not Found");
        }else{
            Food food = foods.get(index);
            imageView = findViewById(R.id.image_view);
            judultextView = findViewById(R.id.judul_tv);
            hargaTextView = findViewById(R.id.harga_tv);
            descTextView = findViewById(R.id.deksripsi_tv);

            imageView.setImageDrawable(food.imagePath);
            judultextView.setText(food.name);
            hargaTextView.setText(food.price);
            descTextView.setText(food.deskripsi);
        }
    }
}