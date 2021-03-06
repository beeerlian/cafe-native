package com.example.utsprakpam;


import android.content.Context;
import com.example.utsprakpam.database.DatabaseHelper;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Food> getAllFood(Context context){
        String[] foodsName = {"batagor", "black salad", "cappuchino", "cheesecake", "cireng"};
        String[] foodsDesc = {context.getString(R.string.batagor_desc),
                context.getString(R.string.black_salad_desc),
                context.getString(R.string.cappuchino_desc),
                context.getString(R.string.cheese_cake_desc),
                context.getString(R.string.cireng_desc)};
        String[] foodsPrices = {"10.000", "15.000", "21.000", "30.000", "5.0000"};
        int[] images = {
                R.drawable.batagor,
                R.drawable.black_salad,
                 R.drawable.cappuchino,
                 R.drawable.cheesecake,
                 R.drawable.cireng,
        };
        List<Food> foodList = new ArrayList<Food>();
        for(int i = 0; i < images.length; i++){
            foodList.add(new Food(foodsName[i], foodsDesc[i], context.getDrawable(images[i]), foodsPrices[i], images[i]));
        }
        return foodList;
    }

    public static List<Food> getAllFoodFromDb(Context context){
        DatabaseHelper db = new DatabaseHelper(context);
        List<Food> foodList = db.getAllRecord(context);
        return foodList;
    }
}
