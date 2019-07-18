package com.example.androidmenusdesign;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecipeDbDao {
    private static SQLiteDatabase db;

    public static void initializeInstance(Context context){
        if(db == null){
            RecipeDbHelper helper = new RecipeDbHelper(context);
            db = helper.getWritableDatabase();
        }
    }
    public static void createRecipe(Recipe recipe){
        if(db!= null){
            ContentValues values = new ContentValues();
            values.put(RecipeDbContract.RecipeEntry.COLUMN_NAME, recipe.getName());
            values.put(RecipeDbContract.RecipeEntry.COLUMN_CATEGORY, recipe.getCategory());
            values.put(RecipeDbContract.RecipeEntry.COLUMN_STAR_RATING, recipe.getStarRating());
            values.put(RecipeDbContract.RecipeEntry.COLUMN_FEED_PER_BATCH, recipe.getFeedPerBatch());
            values.put(RecipeDbContract.RecipeEntry.COLUMN_COST_RATING, recipe.getCostRating());
            values.put(RecipeDbContract.RecipeEntry.COLUMN_INGREDIENT_LIST, recipe.getIngredientList());
            values.put(RecipeDbContract.RecipeEntry.COLUMN_DIRECTIONS, recipe.getDirections());
            values.put(RecipeDbContract.RecipeEntry.COLUMN_FAVORITES, recipe.getFavorite());
            db.insertOrThrow(RecipeDbContract.RecipeEntry.TABLE_NAME,null,values);
        }
    }
    public static void deleteRecipe(String recipeName){
        if(db!= null){
            String whereClause = String.format("%s = '%s'", RecipeDbContract.RecipeEntry.COLUMN_NAME,recipeName);
            int affectedRows = db.delete(RecipeDbContract.RecipeEntry.TABLE_NAME,whereClause,null);
        }
    }
    public static ArrayList<Recipe> readAllRecipes(){
        String getRecipes = String.format("SELECT * FROM $s;",RecipeDbContract.RecipeEntry.TABLE_NAME);
        Cursor cursor = db.rawQuery(getRecipes,null);
        int index;
        ArrayList<Recipe> recipeList = new ArrayList<>();
        while(cursor.moveToNext()) {
            index = cursor.getColumnIndexOrThrow(RecipeDbContract.RecipeEntry.COLUMN_NAME);
            String name = cursor.getString(index);
            index = cursor.getColumnIndexOrThrow(RecipeDbContract.RecipeEntry.COLUMN_CATEGORY);
            String category = cursor.getString(index);
            index = cursor.getColumnIndexOrThrow(RecipeDbContract.RecipeEntry.COLUMN_STAR_RATING);
            String starRating = cursor.getString(index);
            index = cursor.getColumnIndexOrThrow(RecipeDbContract.RecipeEntry.COLUMN_FEED_PER_BATCH);
            String feedPerBatch = cursor.getString(index);
            index = cursor.getColumnIndexOrThrow(RecipeDbContract.RecipeEntry.COLUMN_COST_RATING);
            String costRating = cursor.getString(index);
            index = cursor.getColumnIndexOrThrow(RecipeDbContract.RecipeEntry.COLUMN_INGREDIENT_LIST);
            String ingredientList = cursor.getString(index);
            index = cursor.getColumnIndexOrThrow(RecipeDbContract.RecipeEntry.COLUMN_DIRECTIONS);
            String directions = cursor.getString(index);
            index = cursor.getColumnIndexOrThrow(RecipeDbContract.RecipeEntry.COLUMN_FAVORITES);
            String favorite = cursor.getString(index);
            Recipe recipe = new Recipe(name, category, Integer.parseInt(starRating), Integer.parseInt(feedPerBatch), Integer.parseInt(costRating), ingredientList, directions);
            recipeList.add(recipe);
        }
        cursor.close();
        return recipeList;

        }
    }

