package com.example.utsprakpam;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static String[] imagesPath = {"batagor", "black_salad", "cappuchino", "cheesecake", "cireng"};
    public static String[] foodsName = {"batagor", "black_salad", "cappuchino", "cheesecake", "cireng"};
    public static String[] foodsDesc = {"batagor Desc", "black_salad desc", "cappuchino desc", "cheesecake desc", "cireng desc"};
    public static String[] foodsPrices = {"10.000", "15.000", "21.000", "30.000", "5.0000"};



    public static List<Food> getAllFood(List<Drawable> image){
        List<Food> foodList = new ArrayList<Food>();
        for(int i = 0; i < image.size(); i++){
            foodList.add(new Food(foodsName[i], foodsDesc[i], image.get(i), foodsPrices[i] ));
        }
        return foodList;
    }
}
