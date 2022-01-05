package com.example.utsprakpam.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;

import com.example.utsprakpam.Food;
import com.example.utsprakpam.R;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    // static variable
    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "Cafe.db";
    private static final String TABLE_FOODS = "foods";

    // column tables
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PATH = "imagePath";
    private static final String KEY_DESCR = "descr";
    private static final String KEY_PRICE = "price";



    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void initData(Context context){
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
        for(int i = 0; i < foodList.size(); i++){
            addRecord(foodList.get(i));
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FOODS_TABLE = "CREATE TABLE " + TABLE_FOODS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_PATH + " INTEGER," + KEY_DESCR + " TEXT,"
                + KEY_PRICE + " TEXT" + ")";
        db.execSQL(CREATE_FOODS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOODS);
        onCreate(db);
    }
    public void addRecord(Food food){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, food.name);
        values.put(KEY_DESCR, food.deskripsi);
        values.put(KEY_PATH, food.imageUri);
        values.put(KEY_PRICE, food.price);

        db.insert(TABLE_FOODS, null, values);
        db.close();
    }
    public List<Food> getAllRecord(Context context) {

        List<Food> foodList = new ArrayList<Food>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FOODS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int i = 0;
        if (cursor.moveToFirst()) {
            do {
                Food food = new Food(cursor.getString(1),
                        cursor.getString(3), context.getDrawable(cursor.getInt(2)),  cursor.getString(4), cursor.getInt(2));

                foodList.add(food);
                i++;
            } while (cursor.moveToNext());
        }

        // return contact list
        return foodList;
    }
    public int getFoodsCount() {
        try{
            String countQuery = "SELECT  * FROM " + TABLE_FOODS;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(countQuery, null);
            cursor.close();

            // return count
            return cursor.getCount();
        }catch (SQLiteException e){
            return 0;
        }
    }
}
