package com.example.androidmenusdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddRecipeActivity extends AppCompatActivity {
    EditText etName, etStarRating, etCostRating, etFeeds, etCategory, etIngredientList, etDirections;
    String name,category,ingredientList,directions;
    int starRating, costRating, id, feeds;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        etName = findViewById(R.id.et_name);
        etStarRating = findViewById(R.id.et_star_rating);
        etCostRating = findViewById(R.id.et_cost_rating);
        etFeeds = findViewById(R.id.et_feeds);
        etCategory = findViewById(R.id.et_category);
        etIngredientList = findViewById(R.id.et_ingredient_list);
        etDirections = findViewById(R.id.et_directions);
        saveButton = findViewById(R.id.nr_save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                category = etCategory.getText().toString();
                ingredientList = etIngredientList.getText().toString();
                directions = etDirections.getText().toString();
                starRating = Integer.parseInt(etStarRating.getText().toString());
                costRating = Integer.parseInt(etCostRating.getText().toString());
                feeds = Integer.parseInt(etFeeds.getText().toString());
                Recipe savedRecipe = new Recipe(name,category,starRating,feeds,costRating,
                ingredientList,directions);
                RecipeRepo.recipeList.add(savedRecipe);


            }
        });

    }
}
