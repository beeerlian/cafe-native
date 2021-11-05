package com.example.utsprakpam.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

        RecyclerView foodRV = findViewById(R.id.rvFoodList);
        foodList = DataSource.getAllFood(getApplicationContext());

        FoodAdapter adapter = new FoodAdapter(foodList);
        foodRV.setAdapter(adapter);
        foodRV.setLayoutManager(new LinearLayoutManager(this));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        startActivity(new Intent(this, MainActivity.class));
        this.finish();

        return true;
    }

}