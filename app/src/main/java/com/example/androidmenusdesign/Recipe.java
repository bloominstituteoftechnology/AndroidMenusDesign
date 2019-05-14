package com.example.androidmenusdesign;

public class Recipe {
    private int id, starRating, costRating, feedPerBatch;
    private String name, directions, ingredientList,category;

    public Recipe(String name, String category, int starRating, int feedPerBatch,int costRating,String ingredientList,String directions) {
        this.starRating = starRating;
        this.costRating = costRating;
        this.feedPerBatch = feedPerBatch;
        this.name = name;
        this.directions = directions;
        this.ingredientList = ingredientList;
        this.category = category;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public int getCostRating() {
        return costRating;
    }

    public void setCostRating(int costRating) {
        this.costRating = costRating;
    }

    public int getFeedPerBatch() {
        return feedPerBatch;
    }

    public void setFeedPerBatch(int feedPerBatch) {
        this.feedPerBatch = feedPerBatch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(String ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
