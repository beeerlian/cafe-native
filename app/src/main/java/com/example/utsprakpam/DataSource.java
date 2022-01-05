package com.example.utsprakpam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.utsprakpam.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class DataSource {



    public static List<Food> getAllFood(Context context){
        String[] imagesPath = {"batagor", "black_salad", "cappuchino", "cheesecake", "cireng"};
        String[] foodsName = {"batagor", "black salad", "cappuchino", "cheesecake", "cireng"};
        String[] foodsDesc = {context.getString(R.string.batagor_desc),
                context.getString(R.string.black_salad_desc),
                context.getString(R.string.cappuchino_desc),
                context.getString(R.string.cheese_cake_desc),
                context.getString(R.string.cireng_desc)};
        String[] foodsPrices = {"10.000", "15.000", "21.000", "30.000", "5.0000"};
        Drawable[] drawableImages = {
                context.getDrawable(R.drawable.batagor),
                context.getDrawable(R.drawable.black_salad),
                context.getDrawable(R.drawable.cappuchino),
                context.getDrawable(R.drawable.cheesecake),
                context.getDrawable(R.drawable.cireng)};
        int[] images = {
                R.drawable.batagor,
                R.drawable.black_salad,
                 R.drawable.cappuchino,
                 R.drawable.cheesecake,
                 R.drawable.cireng,
        };
        List<Food> foodList = new ArrayList<Food>();
        for(int i = 0; i < drawableImages.length; i++){
            foodList.add(new Food(foodsName[i], foodsDesc[i], drawableImages[i], foodsPrices[i], images[i]));
        }
        return foodList;
    }

    public static List<Food> getAllFoodFromDb(Context context){
        DatabaseHelper db = new DatabaseHelper(context);
        List<Food> foodList = new ArrayList<Food>();
        foodList = db.getAllRecord(context);
        return foodList;
    }
}
