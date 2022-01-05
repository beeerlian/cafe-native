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
import com.example.utsprakpam.database.DatabaseHelper;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    List<Food> foodList;


    //ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DatabaseHelper db  = new DatabaseHelper(getApplicationContext());
//        foodList = db.getAllRecord(getApplicationContext());

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_dashboard);

        RecyclerView foodRV = findViewById(R.id.rvFoodList);
//        int count = db.getFoodsCount();
//        if(count==0){
//            db.initData(getApplicationContext());
//            foodList = DataSource.getAllFoodFromDb(getApplicationContext());
//        }else{
//
//
//        }

        foodList = DataSource.getAllFoodFromDb(getApplicationContext());

        FoodAdapter adapter = new FoodAdapter(foodList);
        foodRV.setAdapter(adapter);
        foodRV.setLayoutManager(new LinearLayoutManager(this));
    }

    public void initDatabaseData(){
        DatabaseHelper db  = new DatabaseHelper(getApplicationContext());
        db.initData(getApplicationContext());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sign_out:
                signOut();
                break;
            case R.id.init_data:
                initDatabaseData();
                break;
        }
        return true;
    }
    public void signOut(){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }
}