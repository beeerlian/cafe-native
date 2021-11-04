package com.example.utsprakpam;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class DataSource {


    List<Food> myFoodlist = new ArrayList<Food>();

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
        List<Food> foodList = new ArrayList<Food>();
        for(int i = 0; i < drawableImages.length; i++){
            foodList.add(new Food(foodsName[i], foodsDesc[i], drawableImages[i], foodsPrices[i]));
        }
        return foodList;
    }
}
