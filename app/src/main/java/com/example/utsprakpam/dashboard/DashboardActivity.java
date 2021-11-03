package com.example.utsprakpam.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.utsprakpam.DataSource;
import com.example.utsprakpam.Food;
import com.example.utsprakpam.FoodAdapter;
import com.example.utsprakpam.MainActivity;
import com.example.utsprakpam.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    List<Food> foodList;

    //ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        RecyclerView articlesRV = findViewById(R.id.rvFoodList);
        //imageView = findViewById(R.id.imageView);
        foodList = DataSource.getAllFood(getDrawableImagesfromStringPath(DataSource.imagesPath));

        FoodAdapter adapter = new FoodAdapter(foodList);
        articlesRV.setAdapter(adapter);
        articlesRV.setLayoutManager(new LinearLayoutManager(this));
    }

    Drawable getDrawablePath(String path){
        int imageResource = getResources().getIdentifier(path, null, getPackageName());
        return getResources().getDrawable(imageResource);
    }

    public List<Drawable> getDrawableImagesfromStringPath(String[] paths){
        List<Drawable> drawables = new ArrayList<Drawable>();
        for(String path : paths){
            drawables.add(getDrawablePath("@drawable/"+path));
        }
        return drawables;
    }

    public void gotoDetail(View view){
        Intent gotoDetail = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(gotoDetail);
        this.finish();
    }
}