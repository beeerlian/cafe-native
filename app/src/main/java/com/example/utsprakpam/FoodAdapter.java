package com.example.utsprakpam;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utsprakpam.detail.DetailActivity;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    public List<Food> foodList;

    public FoodAdapter(List<Food> foodList){
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View FoodView = inflater.inflate(R.layout.item_food, parent, false);

        ViewHolder itemVH = new ViewHolder(FoodView);
        return itemVH;
    }

    @Override
    public void onBindViewHolder(FoodAdapter.ViewHolder holder, int position) {
        Food food = foodList.get(position);

        TextView foodTV = holder.titleTV;
        ImageView foodImageView = holder.imageTv;
        TextView priceTV = holder.priceTV;
        priceTV.setText(food.price);
        foodTV.setText(food.name);
        //foodTV.setBackground(food.imagePath);
        foodImageView.setImageDrawable(food.imagePath);

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView titleTV;
        public TextView priceTV;
        public ImageView imageTv;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            titleTV = (TextView) itemView.findViewById(R.id.nameFoodTV);
            priceTV = (TextView) itemView.findViewById(R.id.priceFoodTv);
            imageTv = (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {
            int layoutPosition = getLayoutPosition();
            Intent intent = new Intent(view.getContext(), DetailActivity.class);
            intent.putExtra("index", layoutPosition);
            view.getContext().startActivity(intent);
        }
    }
}
